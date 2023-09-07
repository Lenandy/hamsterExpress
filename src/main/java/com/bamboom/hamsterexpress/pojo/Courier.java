package com.bamboom.hamsterexpress.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//递送员
public class Courier {
    private String courierName;     //递送员姓名
    private Integer phoneNumber;    //递送员手机号码

}
