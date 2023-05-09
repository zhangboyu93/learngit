package com.learn.springcloud.service;

import com.learn.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "SPRING-PROVIDER-DEPT")
public interface DeptClientServiceFeign {
    @GetMapping("/dept/query/{id}")
    public Dept queryById(@PathVariable("id") int id);
    @GetMapping("/dept/getall")
    public List<Dept> queryAll();
    @PostMapping("/dept/add")
    public boolean add(Dept dept);
}
