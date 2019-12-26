package com.ley.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Usage:
 *     @Autowired
 *     private ThreadPoolTaskExecutor taskExecutor;
 *
 *     public testNoReturn() {
 *        taskExecutor.execute(new Runnable() {
 *             public void run() {
 *                 try {
 *                     Thread.sleep(2000);
 *                 } catch (InterruptedException e) {
 *                     e.printStackTrace();
 *                 }
 *             }
 *         });
 *     }
 *
 *     public String hasReturn() throws ExecutionException, InterruptedException {
 *         Future<String> future = taskExecutor.submit(new Callable<String>() {
 *             public String call() throws Exception {
 *                 Thread.sleep(3000);
 *                 return "执行成功";
 *             }
 *         });
 *     }
 *
 */
@Configuration
public class ThreadConfig {
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(7);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return taskExecutor;
    }
}
