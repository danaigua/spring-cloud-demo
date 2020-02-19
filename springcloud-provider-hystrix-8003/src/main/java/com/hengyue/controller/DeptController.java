package com.hengyue.controller;

import com.hengyue.entity.Dept;
import com.hengyue.service.IDeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private IDeptService deptService;

    public Object getFallback(@PathVariable("id")long id){
        Dept dept = new Dept(10L, "test", "test");
        return dept;
    }

    @RequestMapping(value = "/get/{deptno}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getFallback")
    public Dept get(@PathVariable Long deptno){
        Dept dept = deptService.findByDeptNo(deptno);
        if (dept == null){
            throw new RuntimeException("部门不存在");
        }
        return dept;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public boolean add(@RequestBody Dept dept) throws Exception{
        return deptService.doCreate(dept);
    }

}
