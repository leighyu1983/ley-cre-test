package com.ley.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.ErrorHandler;

@EnableScheduling
@Configuration
public class SchedulerConfig {
    //@Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("ley-task");
        taskScheduler.setAwaitTerminationSeconds(6);
        taskScheduler.setErrorHandler(new ErrorHandler() {
            @Override
            public void handleError(Throwable throwable) {
                System.out.println(throwable.getMessage() + throwable.getMessage());
            }
        });
        taskScheduler.initialize();
        return taskScheduler;
    }
}
