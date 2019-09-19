package com.ley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * mybatis / pagehelper / mapper (annotation without xml file)
 * mybatis (SelectInLangDriver extends XMLLanguageDriver implements LanguageDriver)  @Lang(SelectInLangDriver.class)
 * swagger
 * token
 * h2 (pom / application.yaml)
 * actuator ()
 * maven plugins - commit number and git commit
 * ProertySource(value="${APP_PATH}/subDir")
 * Global Exception
 *
 *
 */
@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}