package com.ley.scheduler;


import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class TestScheduler {

    /**
     * SchedulerConfig 需要注解 @EnableScheduling 和 @Configuration
     *
     * initialDelay 不能单独存在，否则启动报错，作用是延迟多久才启动
     *
     * fixedDelay 间隔多久执行下一次操作
     *
     *
     */
//    @Scheduled(initialDelay = 0*1000L, fixedDelay = 1 * 1000L)
//    public void fixedDelay() throws Exception {
//        Thread.sleep(2000);
//        System.out.println(
//                Thread.currentThread().getName()
//                        + " fixedDelay:"
//                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date()));
//    }

    @Scheduled(initialDelay = 0*1000L, fixedRate = 1 * 1000L)
    public void fixedRate()  throws Exception {
        Thread.sleep(2000);
        if(Thread.currentThread().getName().contains("ley-task5")) {
            throw new Exception("哈哈哈哈");
        }
        System.out.println(
                Thread.currentThread().getName()
                        + " fixedRate:"
                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date()));
    }
}
