package com.ley.controller;

import com.ley.annotation.MyPerformance;
import com.ley.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired AccountService accountService;

    @ApiOperation(value ="插入", notes ="", httpMethod = "GET")
    @RequestMapping("/insert")
    @MyPerformance
    public int insert() {
        return accountService.insert();
    }

    @ApiOperation(value ="更新", notes ="", httpMethod = "GET")
    @RequestMapping("/update")
    public int update() {
        return accountService.update();
    }

    @ApiOperation(value ="In查询", notes ="", httpMethod = "GET")
    @RequestMapping("/queryLikeIn")
    public String queryLikeIn() {
        return accountService.queryLikeIn();
    }

    @ApiOperation(value ="In xml 查询", notes ="", httpMethod = "GET")
    @RequestMapping("/queryLikeInXml")
    public String queryLikeInXml() {
        return accountService.queryLikeInXml();
    }

    @ApiOperation(value ="分页查询", notes ="", httpMethod = "GET")
    @RequestMapping("/queryPaging")
    public String queryPaging() {
        return accountService.queryPaging();
    }

    @ApiOperation(value ="删除", notes ="", httpMethod = "GET")
    @RequestMapping("/delete")
    public String delete() {
        return "";
    }
}
