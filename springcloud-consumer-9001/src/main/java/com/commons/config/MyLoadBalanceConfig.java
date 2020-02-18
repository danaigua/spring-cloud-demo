package com.commons.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class MyLoadBalanceConfig {

    @Bean
    public IRule ribbonRulele(){
        return new RandomRule();
    }
}
