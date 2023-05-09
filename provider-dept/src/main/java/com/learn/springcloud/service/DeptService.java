package com.learn.springcloud.service;

import com.learn.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(int id);

    public List<Dept> queryAll();
}
