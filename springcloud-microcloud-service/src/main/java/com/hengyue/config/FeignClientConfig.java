package com.hengyue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

/**
 * 认证类
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthenticationInterceptor getBaseAuthenicationInterceptor(){
        return new BasicAuthenticationInterceptor("root", "root");
    }

}
