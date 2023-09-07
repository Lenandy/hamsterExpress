package com.bamboom.hamsterexpress.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//订单信息
public class  Order {
    private LocalDateTime orderedTime;      //下单时间(系统后台分配)
    private Integer orderNumber;            //订单号(系统后台分配)

    private Integer storageFee;             //仓储费用(根据保管时间设置)
    private Integer amount;                 //账单金额(仓储费用+递送费)

    private Integer smallPie;               //小件数量(自填加)
    private Integer largePie;               //大件数量(自填加)
    private Integer oversizePie;            //超大数量(自填加)

    private String deliveryMethod;          //递送方式(自填加)
    private String remark;                  //备注(自填加)
    private LocalDateTime deliveryTime;     //递送时间(自填加，必填)
    private Integer trackingNumber;         //快递单号(自填加，必填)
    private String logisticsCompany;        //快递公司(自填加，必填)
    private Integer code;                   //取件码(自填加，必填)

}
