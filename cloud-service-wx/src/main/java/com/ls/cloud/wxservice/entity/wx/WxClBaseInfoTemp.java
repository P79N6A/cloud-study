package com.ls.cloud.wxservice.entity.wx;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WxClBaseInfoTemp {

    private Integer id;

    private String biz_order_no;

    private BigDecimal apply_amount;

    private Integer repayment_terms;

    private Integer repayment_method;

    private String create_date;
}
