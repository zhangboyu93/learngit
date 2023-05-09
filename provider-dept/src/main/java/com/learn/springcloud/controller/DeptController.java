package com.learn.springcloud.controller;

import com.learn.springcloud.pojo.Dept;
import com.learn.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/query/{id}")
    public Dept queryById(@PathVariable("id") int id){
        return deptService.queryById(id);
    }
    @GetMapping("/dept/getall")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

//    获取微服务列表信息
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery:===>"+services);
//        获取其中一个
//        List<ServiceInstance> instances = discoveryClient.getInstances();
        return discoveryClient;
    }
}
