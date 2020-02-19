package com.hengyue;

import com.commons.config.MyLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient/* 自动注册到eureka中 */
@RibbonClient(name = "ribbonClient", configuration = MyLoadBalanceConfig.class)     /*修改客户端的负载均衡策略*/
@EnableHystrixDashboard         /**具备监控的功能*/
public class SpringcloudConsumer9001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumer9001Application.class, args);
    }

}
