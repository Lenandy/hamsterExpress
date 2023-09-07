package com.bamboom.hamsterexpress.pojo;

import jakarta.xml.soap.SAAJResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//用户
public class Emp {
    private String username;            //用户姓名
    private Integer phone;              //用户手机
    private String address;             //客户收件地址

}
