package com.ley.controller;

import com.ley.entity.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired HttpServletRequest request;

    @RequestMapping("/accesstoken")
    public ResponseObj login(@RequestBody Map<String, String> params) {
        System.out.println(params);
        String token = params.get("username") + "|token|" + params.get("password");
        return ResponseObj.success(token);
    }

    @RequestMapping("/expire")
    public ResponseObj expire(@RequestBody Map<String, String> params) {
        System.out.println(params);
        String token = params.get("username") + "|token|" + params.get("password");
        return ResponseObj.error(101, null);
    }
}
