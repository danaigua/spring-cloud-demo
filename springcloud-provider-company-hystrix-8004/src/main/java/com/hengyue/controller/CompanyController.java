package com.hengyue.controller;

import com.hengyue.entity.Company;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @RequestMapping(value = "/company/get/{title}", method = RequestMethod.GET)
    @HystrixCommand  /**如果需要进行性能监控就必须要加入此注解*/
    public Object get(@PathVariable("title") String title){
        Company company = new Company();
        company.setTitle(title);
        company.setNote("test");
        return company;
    }

}
