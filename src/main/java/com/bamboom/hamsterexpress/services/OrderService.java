package com.bamboom.hamsterexpress.services;


import com.bamboom.hamsterexpress.pojo.Order;

import java.util.List;

public interface OrderService {
    //查询订单
    List<Order> list();
    //新增订单信息
    void addOrder(Order order);
    void updateOrder(Order order);
    //获取订单号
    Integer getOrderNumber();
}
