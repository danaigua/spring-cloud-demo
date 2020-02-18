package com.hengyue.service;

import com.hengyue.entity.Dept;

import java.util.List;

public interface IDeptService {

    public boolean doCreate(Dept dept);

    public List<Dept> listAll();

    public Dept findByDeptNo(Long deptno);
}
