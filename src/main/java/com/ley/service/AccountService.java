package com.ley.service;

import com.ley.entity.AccountEntity;
import com.ley.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class AccountService {

    @Autowired AccountMapper accountMapper;

    public int insert() {
        AccountEntity accountEntity =
                new AccountEntity(0, "name0", "this is address 0");
        int id = accountMapper.insert(accountEntity);
        return id;
    }

    public String insertWithXml() {
        return "";
    }

    public String update() {
        return "";
    }

    public String querySimple() {
        return "";
    }

    public String queryJoin() {
        return "";
    }

    public String queryPaging() {
        return "";
    }

    public String queryIn() {
        return "";
    }

    public String delete() {
        return "";
    }
}
