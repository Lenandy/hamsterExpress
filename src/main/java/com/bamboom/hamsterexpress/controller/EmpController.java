package com.bamboom.hamsterexpress.controller;

import com.bamboom.hamsterexpress.pojo.Emp;
import com.bamboom.hamsterexpress.pojo.Result;
import com.bamboom.hamsterexpress.services.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    //查询用户数据
    @GetMapping("list")
    public Result list() {
        log.info("发送客户信息");
        List<Emp> emplist = empService.list();
        return Result.success(emplist);
    }

    //更新用户信息
    @PutMapping("/{id}")
    public Result update(@PathVariable Emp emp){
        log.info("根据ID查询用户信息: {}",emp);
        empService.update(emp);
        return Result.success();
    }

    //新增用户信息
    @PostMapping("updateEmp")
    public Result add(@RequestBody Emp emp){
        log.info("新增用户信息");
        empService.add(emp);
        return Result.success();
    }



}
