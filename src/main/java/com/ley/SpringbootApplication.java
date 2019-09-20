package com.ley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * mybatis / mapper (annotation without xml file)
 * mybatis (SelectInLangDriver extends XMLLanguageDriver implements LanguageDriver)  @Lang(SelectInLangDriver.class)
 * pagehelper aop
 * swagger (ApiOperation)
 * token
 * h2 (pom / application.yaml)
 * actuator ()
 * maven plugins - commit number and git commit
 * ProertySource(value="${APP_PATH}/subDir")
 * lombok(remove byte[] field in EqualsAndHashCode, ToString) (add constructor annotation)
 * Global Exception
 * inject with annotation and constructor(refer to example in TestController)
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}