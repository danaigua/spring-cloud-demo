package com.hengyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProvider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8002Application.class, args);
    }

}
