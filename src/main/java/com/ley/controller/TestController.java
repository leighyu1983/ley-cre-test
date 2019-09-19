package com.ley.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {

    @ApiOperation(value ="测试接口", notes ="", httpMethod = "GET")
    @RequestMapping("test")
    public String test() {
        return "hello world";
    }


}
