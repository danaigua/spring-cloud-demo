package com.hengyue.dao;

import com.hengyue.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDeptDao {

    public boolean doCreate(Dept dept);

    public List<Dept> listAll();

    public Dept findByDeptNo(Long deptno);
}
