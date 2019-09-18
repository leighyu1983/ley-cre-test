package com.ley.controller;

import com.ley.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired AccountService accountService;

    @RequestMapping("/insert")
    public int insert() {
        return accountService.insert();
    }

    @RequestMapping("/insertWithXml")
    public String insertWithXml() {
        return "";
    }

    @RequestMapping("/update")
    public String update() {
        return "";
    }

    @RequestMapping("/querySimple")
    public String querySimple() {
        return "";
    }

    @RequestMapping("/queryJoin")
    public String queryJoin() {
        return "";
    }

    @RequestMapping("/queryPaging")
    public String queryPaging() {
        return "";
    }

    @RequestMapping("/queryIn")
    public String queryIn() {
        return "";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "";
    }
}
