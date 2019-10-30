package com.ley.controller;

import com.ley.entity.AccountEntity;
import com.ley.entity.ResponseObj;
import com.ley.enums.*;
import com.ley.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    /* Bean registration with constructor */
    private TestService testService;
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation(value ="测试基于构造器的bean注入", notes ="", httpMethod = "GET")
    @RequestMapping("/bean-registion")
    public String testBeanRegistration() {
        return this.testService.testService();
    }

    @ApiOperation(value ="测试异常处理", notes ="", httpMethod = "GET")
    @RequestMapping("/exception-hanlding")
    public String testExceptionHandling() throws Exception {
        this.testService.throwException();
        return "test exception handling";
    }

    @ApiOperation(value ="Test Lambda LoopReturnNewList",
            notes ="stream().map(e->xxx).collect(Collectors.toList())", httpMethod = "GET")
    @RequestMapping("/loopreturnnewlist")
    public String testLambdaLoopReturnNewList() throws Exception {
        List<AccountEntity> accounts = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            AccountEntity e = new AccountEntity(i, "a" + i, "addr", null);
            accounts.add(e);
        }
        Optional<List<AccountEntity>> optionalAccounts =
               Optional.ofNullable(accounts);

        if(!optionalAccounts.isPresent()) {
            return "testLambdaLoopReturnNewList not present";
        }
        List<ResponseObj> objs = optionalAccounts.get().stream()
                .map(e -> new ResponseObj(0, null, e.getName()))
                .collect(Collectors.toList());

        return "testLambdaLoopReturnNewList";
    }

    @ApiOperation(value ="测试吃内存", notes ="", httpMethod = "GET")
    @RequestMapping("/eat-memory")
    public String testEatMemory() throws Exception {
        // update vm option
        List<String> str = new ArrayList<>();
        while(true) {
            str.add("hey");
        }
        //return "test eat memory";
    }

    @ApiOperation(value ="测试枚举", notes ="", httpMethod = "GET")
    @RequestMapping("/enum-to-string")
    public String testEnumToString() throws Exception {
        EnumStatus status = EnumStatus.findByCode(1);
        return status.getStatus();
    }

    @ApiOperation(value ="测试Lambda map 返回单值", notes ="", httpMethod = "GET")
    @RequestMapping("/lambda-map-single")
    public void testLambdaMap() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Optional<List<String>> listOptional = Optional.of(list);

        listOptional.map(x -> {
            this.testService.print(x.get(0));
            return x;
        });
    }
}
