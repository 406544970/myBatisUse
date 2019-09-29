package com.lh.mybatisuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LhApplication {

    public static void main(String[] args) {
        SpringApplication.run(LhApplication.class, args);
        System.out.println("http://localhost:2519/swagger-ui.html");
    }
}
