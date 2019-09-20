package com.ley.service.impl;

import com.ley.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testService() {
        return "this is test service....";
    }
}
