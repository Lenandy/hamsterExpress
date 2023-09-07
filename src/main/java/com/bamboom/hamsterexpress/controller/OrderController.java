package com.bamboom.hamsterexpress.controller;

import com.bamboom.hamsterexpress.pojo.Order;
import com.bamboom.hamsterexpress.pojo.Result;
import com.bamboom.hamsterexpress.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController

public class OrderController {
    @Autowired
    private OrderService orderService;

    //查询订单信息
    @GetMapping ("getOrder")
    public Result list(){
        log.info("查询订单订单信息");
        List<Order> orderlist = orderService.list();
        return Result.success();
    }

    //新增订单信息
    @PostMapping
    public Result add(@RequestBody Order order){
        log.info("新增订单信息");
        orderService.addOrder(order);
        return Result.success();
    }

    //更新订单信息
    @PutMapping
    public Result update(@RequestBody Order order){
        log.info("新增订单信息:{}",order);
        orderService.updateOrder(order);
        return Result.success();
    }

}
