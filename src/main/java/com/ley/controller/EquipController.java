package com.ley.controller;

import com.ley.entity.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/equip")
public class EquipController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/list")
    public ResponseObj list(@RequestBody Map<String, String> params) {
        System.out.println(params);
        String token = params.get("name") + "|equip list";
        return ResponseObj.success(token);
    }
}
