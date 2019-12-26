package com.ley.controller;

import com.ley.service.ThreadPoolTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadPoolController {
    private @Autowired ThreadPoolTestService threadPoolTestService;

    @GetMapping("/thread-pool-executor")
    public void testThreadPoolExecutorBasic() {
        threadPoolTestService.testThreadPoolExecutorBasic();
    }

    @GetMapping("/thread-pool-executor-wait-all-finish-and-result")
    public void testThreadPoolExecutorWaitFinishWithResult() {
        threadPoolTestService.testThreadPoolExecutorWaitFinishWithResult();
    }

}
