package com.bamboom.hamsterexpress.services.impl;
import com.bamboom.hamsterexpress.mapper.EmpMapper;
import com.bamboom.hamsterexpress.pojo.Emp;
import com.bamboom.hamsterexpress.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    //新增方法
    public void add(Emp emp) {
        //emp.setOrderTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    //查询用户信息
    @Override
    public List<Emp> list() {
        return empMapper.list();
    }

    //更新用户信息
    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }


}

