package com.bamboom.hamsterexpress.mapper;

import com.bamboom.hamsterexpress.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    //新增数据至数据库
    @Insert("insert into table_emp(username, phone,address)value " +
            "(#{username},#{phone},#{address})")
    void insert(Emp emp);

    //查询用户信息
    @Select("select username, phone, address from table_emp")
    List<Emp> list();

    //更新用户信息
    void update(Emp emp);
}
