package com.learn.springcloud.service;

import com.learn.springcloud.dao.DeptDao;
import com.learn.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    DeptDao deptDao;
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);

    }

    @Override
    public Dept queryById(int id) {
        return deptDao.queryById(id);

    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
