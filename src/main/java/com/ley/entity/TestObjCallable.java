package com.ley.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;


public class TestObjCallable implements Callable<String> {
    private String name;

    public TestObjCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date())
                        + Thread.currentThread().getName() + " biz name:" + name);
        return "SUCCESS";
    }
}
