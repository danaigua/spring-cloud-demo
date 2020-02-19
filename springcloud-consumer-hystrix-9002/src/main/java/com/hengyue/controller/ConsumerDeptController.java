package com.hengyue.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import com.hengyue.entity.Dept;

@RestController
public class ConsumerDeptController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @RequestMapping(value = "/consumer/dept/get")
    public Object getDept(Long id){
        return this.restTemplate.exchange("http://MICTOCLOUD-PROVIDER-DEPT/dept/get/1", HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Dept.class);
//        return restTemplate.getForObject("http://MICTOCLOUD-PROVIDER-DEPT/dept/get/1",  Dept.class);
    }
}
