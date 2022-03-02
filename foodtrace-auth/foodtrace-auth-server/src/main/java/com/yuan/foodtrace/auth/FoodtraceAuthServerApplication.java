package com.yuan.foodtrace.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FoodtraceAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodtraceAuthServerApplication.class, args);
    }

}
