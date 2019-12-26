package com.ley.service;

import com.ley.entity.TestObjCallable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ThreadPoolTestService {
    private final static int CORE_POOL_SIZE = 10;
    private final static int MAX_POOL_SIZE = 20;
    private final static int KEEP_ALIVE_MILLI_SEC = 500;

    /**
     * Create Thread Factory for creating thread name prefix
     */
    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "ley-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    /**
     * ThreadPoolExecutor (java.util.concurrent)
     */
    public void testThreadPoolExecutorBasic() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_MILLI_SEC, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                new NameTreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for(int i = 0; i < 20; i++) {
            executor.execute(() -> {
                System.out.println(
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date())
                                + Thread.currentThread().getName());
            });
        }
    }

    /**
     * ThreadPoolExecutor (java.util.concurrent)
     */
    public void testThreadPoolExecutorWaitFinishWithResult() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_MILLI_SEC, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                new NameTreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        List<Future<String>> asyncResults = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            asyncResults.add(executor.submit(new TestObjCallable(String.valueOf(i))));
        }

        /**
         * wait until all threads finish running
         */
        for(Future<String> future : asyncResults) {
            try {
                future.get(60 * 1000, TimeUnit.MILLISECONDS);
            }catch(Exception ex) {
                System.out.println("unhandled exception of TestThreadPoolExecutorWaitFinish()");
            }
        }

        System.out.println("all finished....");
    }
}
