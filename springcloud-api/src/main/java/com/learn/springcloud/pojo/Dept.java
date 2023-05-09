package com.learn.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法 可以set().set().set()
public class Dept implements Serializable {
    private Integer deptNo;
    private String deptName;
    private String dept_source;
    public Dept(String deptName) {
        this.deptName = deptName;
    }

}
