package com.ley.controller;

import com.ley.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {

    /* Bean registration with constructor */
    private TestService testService;
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation(value ="测试基于构造器的bean注入", notes ="", httpMethod = "GET")
    @RequestMapping("test")
    public String testBeanRegistration() {
        return this.testService.testService();
    }
}
