package com.learn.springcloud.controller;

import com.learn.springcloud.pojo.Dept;
import com.learn.springcloud.service.DeptClientServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法
//   消费者这边想要调用服务端的服务 需要服务端的url
//    private static final String REST_URL_PREFIX="http://localhost:8001";
//    private static final String REST_URL_PREFIX="http://SPRING-PROVIDER-DEPT";
//    通过ribbon实现的时候 这个是个变量 不能是8001 应该是一个变量 https://SPRING-PROVIDER-DEPT
//    使用feign负载均衡
    @Autowired
    private DeptClientServiceFeign service;
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")int id){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/query/"+id,Dept.class);
        return service.queryById(id);
    }
    @RequestMapping("/consumer/add")
    public boolean add(Dept dept){
//        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept, Boolean.class);
        return service.add(dept);
    }
    @RequestMapping("/consumer/dept/getall")
    public List<Dept> getall(){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/getall", List.class);
        return service.queryAll();
    }

}
