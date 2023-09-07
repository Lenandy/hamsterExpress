package com.bamboom.hamsterexpress.services;

import com.bamboom.hamsterexpress.pojo.Emp;

import java.util.List;

public interface EmpService {
    //添加用户信息
    void add(Emp emp);
    //查询用户信息
    List<Emp> list();
    //更新用户信息
    void update(Emp emp);
}
