package com.ley.service;

import com.ley.entity.AccountEntity;
import com.ley.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountService {

    @Autowired AccountMapper accountMapper;

    public int insert() {
        AccountEntity accountEntity =
                new AccountEntity(0, "name0", "this is address 0");
        int id = accountMapper.insert(accountEntity);
        return id;
    }

    public int update() {
        AccountEntity originalAccount =
                new AccountEntity(100, "name100", "this is address 100");
        accountMapper.insert(originalAccount);

        AccountEntity updateEntity =
                new AccountEntity(100, "name100update", "this is address 100 won't update field");
        return accountMapper.update(updateEntity);
    }

    public String queryLikeIn() {
        // prepare data
        for(int i = 10; i < 13; i++) {
            AccountEntity accountEntity =
                    new AccountEntity(i, "name" + i, "this is address " + i);
            accountMapper.insert(accountEntity);
        }

        // test like
        List<AccountEntity> accountLikes = accountMapper.queryLikeIn("name1", null);

        // test in
        Set<Integer> ids = new HashSet<>();
        ids.add(10);
        ids.add(11);
        List<AccountEntity> accountIn = accountMapper.queryLikeIn("name1", ids);

        // test in failed
        Set<Integer> idsA = new HashSet<>();
        idsA.add(1);
        List<AccountEntity> accountFailed = accountMapper.queryLikeIn("name1", idsA);

        return "check queryLikeIn result in log ";
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
