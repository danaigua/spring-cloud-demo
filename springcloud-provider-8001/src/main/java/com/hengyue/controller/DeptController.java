package com.hengyue.controller;

import com.hengyue.entity.Dept;
import com.hengyue.service.IDeptService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private IDeptService deptService;

    @RequestMapping(value = "/get/{deptno}", method = RequestMethod.GET)
    public Dept get(@PathVariable(value = "deptno") Long deptno){
        return deptService.findByDeptNo(deptno);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public boolean add(@RequestBody Dept dept) throws Exception{
        return deptService.doCreate(dept);
    }

}
