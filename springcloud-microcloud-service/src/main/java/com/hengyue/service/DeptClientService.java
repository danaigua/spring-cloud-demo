package com.hengyue.service;

import com.hengyue.config.FeignClientConfig;
import com.hengyue.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * feign自带负载均衡配置
 */
@FeignClient(value = "服务名", configuration = FeignClientConfig.class)
public interface DeptClientService {
    @RequestMapping(value = "/dept/get/{id}}", method = RequestMethod.GET)
    public Dept get(@PathVariable Long id);

    public List<Dept> list();
}
