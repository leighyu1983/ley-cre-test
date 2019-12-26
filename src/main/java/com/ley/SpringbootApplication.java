package com.ley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

/**
 * Interceptor for security check
 * mybatis / mapper (annotation without xml file)
 * pagehelper aop
 * token
 * h2 (pom / application.yaml)
 * actuator ()
 * maven plugins - commit number and git commit
 * ProertySource(value="${APP_PATH}/subDir")
 * lombok(remove byte[] field in EqualsAndHashCode, ToString) (add constructor annotation)
 * Global Exception(controllerAdvice in case job exception, handle different exception class)
 * inject with annotation and constructor(refer to example in TestController)
 * mybatis (SelectInLangDriver extends XMLLanguageDriver implements LanguageDriver)  @Lang(SelectInLangDriver.class)
 * swagger (ApiOperation)
 * cros
 * interceptor for validating token sample
 * custom invalidToken exception
 */

@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}