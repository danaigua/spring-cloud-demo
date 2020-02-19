package com.hengyue;

import com.hengyue.entity.Dept;
import com.hengyue.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class testDeptService {

    @Resource
    private IDeptService deptService;

    @Test
    public void  testList(){
        System.out.println(deptService.listAll());
    }

    @Test
    public void testAdd(){
        Dept dept = new Dept(10L, "qc", "test");
        System.out.println(deptService.doCreate(dept));
    }

    @Test
    public void testFindByDeptNo(){
        System.out.println(deptService.findByDeptNo(1L));
    }


}
