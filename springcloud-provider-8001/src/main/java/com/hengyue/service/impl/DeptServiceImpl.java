package com.hengyue.service.impl;

import com.hengyue.dao.IDeptDao;
import com.hengyue.entity.Dept;
import com.hengyue.service.IDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {

    @Resource
    private IDeptDao deptDao;

    @Override
    public boolean doCreate(Dept dept) {
        return deptDao.doCreate(dept);
    }

    @Override
    public List<Dept> listAll() {
        return deptDao.listAll();
    }

    @Override
    public Dept findByDeptNo(Long deptno) {
        return deptDao.findByDeptNo(deptno);
    }
}
