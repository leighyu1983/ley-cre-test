package com.ley.controller;

import com.ley.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/test")
public class TestController {

    /* Bean registration with constructor */
    private TestService testService;
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation(value ="测试基于构造器的bean注入", notes ="", httpMethod = "GET")
    @RequestMapping("/bean-registion")
    public String testBeanRegistration() {
        return this.testService.testService();
    }

    @ApiOperation(value ="测试异常处理", notes ="", httpMethod = "GET")
    @RequestMapping("/exception-hanlding")
    public String testExceptionHandling() throws Exception {
        this.testService.throwException();
        return "test exception handling";
    }
}
