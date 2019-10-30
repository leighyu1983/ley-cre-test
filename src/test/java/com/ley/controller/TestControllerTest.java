package com.ley.controller;

import com.ley.service.impl.TestServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestControllerTest {

    @Autowired TestServiceImpl testService;
    @Autowired TestController testController;

    @Test
    void testLambdaMapService() {
        testService.print("test case 1");
    }

    @Test
    void testLambdaMapController() {
        testController.testLambdaMap();
    }
}