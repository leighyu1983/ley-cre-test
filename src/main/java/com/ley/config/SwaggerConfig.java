package com.ley.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
//@Profile("swagger")
public class SwaggerConfig {

    @Value("${app.swagger.external.url:localhost:888}")
    protected String externalUrl="";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.host(externalUrl)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ley.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private static ApiInfo apiInfo() {
        return new ApiInfo(
                "Leigh Test API",
                "",
                "3.5",
                "Test use only",
                null,
                "", "", Collections.emptyList());
    }
}
