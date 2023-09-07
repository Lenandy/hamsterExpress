package com.bamboom.hamsterexpress.mapper;

import com.bamboom.hamsterexpress.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    

    //新增订单
    @Insert("insert into hamsterexpress.table_order(order_number, amount, storage_fee, ordered_time, small_pie, large_pie, oversize_pie, delivery_method, delivery_time, remark) " +
            "VALUES (#{orderNumber},#{amount},#{storageFee},#{orderedTime},#{smallPie},#{largePie},#{oversizePie},#{deliveryMethod},#{deliveryTime},#{remark})")
    void insert(Order order);

    //查询订单
    @Select("select order_number, amount, storage_fee, ordered_time, small_pie, large_pie, oversize_pie, delivery_method, delivery_time, remark from table_order")
    List<Order> list();

    //更新数据
    void updateOrder(Order order);
}
