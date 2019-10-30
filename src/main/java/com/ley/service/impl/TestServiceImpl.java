package com.ley.service.impl;

import com.ley.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testService() {
        return "this is test service....";
    }

    @Override
    public void throwException() throws Exception {
        throw new Exception("meant to throw exception");
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
