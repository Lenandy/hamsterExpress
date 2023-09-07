package com.bamboom.hamsterexpress.services.impl;

import com.bamboom.hamsterexpress.mapper.OrderMapper;
import com.bamboom.hamsterexpress.pojo.Order;
import com.bamboom.hamsterexpress.services.OrderService;
import com.bamboom.hamsterexpress.util.OrderCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderCodeUtils orderCodeUtils;

    //查询订单信息
    @Override
    public List<Order> list() {
        return orderMapper.list();
    }

    //新增订单信息
    @Override
    public void addOrder(Order order) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        order.setOrderedTime(LocalDateTime.now());
        order.setOrderNumber(getOrderNumber());
        order.setAmount(toSetAmount(order));
        orderMapper.insert(order);
    }

    //更新订单
    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    //获取订单码
    @Override
    public Integer getOrderNumber() {
        return orderCodeUtils.createOrderCode;
    }

    //获取递送金额
    public Integer toSetAmount(Order order){
        int cash;
        //总金额 = 快件金额 + 存储费
        cash = order.getSmallPie() * 3 + order.getLargePie() * 5 + order.getOversizePie() * 10 + toGetStorageFee(order);
        return cash;
    }


    public Integer toGetStorageFee(Order order) {
        int storageFee = 0;
        if (order.getOrderedTime() == null || order.getDeliveryTime() == null || order.getSmallPie() == null || order.getLargePie() == null || order.getOversizePie() == null) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime curDateTime = order.getOrderedTime();
        LocalDateTime afterDateTime = order.getDeliveryTime();
        Duration between = Duration.ofDays(afterDateTime.getDayOfYear() - curDateTime.getDayOfYear());
        long betweenDay = between.toDays();

        if (betweenDay >= 14) {
            storageFee = order.getSmallPie() * 3 + order.getLargePie() * 5 + order.getOversizePie() * 10;
            return storageFee;
        }
        return storageFee;

    }

}
