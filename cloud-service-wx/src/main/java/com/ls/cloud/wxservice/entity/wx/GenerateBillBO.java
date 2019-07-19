package com.ls.cloud.wxservice.entity.wx;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 生成账单业务对象
 */
@Data
public class GenerateBillBO {
    /**
     * 外单号
     */
    private String bizOrderNo;
    /**
     * 内单号
     */
    private String loadOrderNo;
    /**
     * 渠道
     */
    private String coopChannel;
    /**
     * 申请金额
     */
    private BigDecimal applyAmount;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户身份证号码
     */
    private String userIdCard;
    /**
     * 放款日期
     */
    private LocalDate loanDate;
    /**
     * 订单期数
     */
    private Integer repaymentTerms;
    /**
     * 利息年利率，如果有百分号的应当先除以100
     */
    private BigDecimal interestRate;
    /**
     * 服务费年利率，如果有百分号的应当先除以100
     */
    private BigDecimal serviceRate;
    /**
     * 利息支付方式：0-第零期一次性收取，1-按月收取
     */
    private Integer interestPayMode;
    /**
     * 利息计算方式：0-固定金额，1-按利率计算
     */
    private Integer interestCalculateMode;
    /**
     * 服务费收取方式：0-第零期一次性收取，1-按月收取
     */
    private Integer servicePayMode;
    /**
     * 服务费计算方式：0-固定金额，1-按服务费利率计算
     */
    private Integer serviceCalculateMode;
    /**
     * 这个值只存放按固定金额收取的利息的金额，如果是月头息则存放第0期应还利息的固定金额，如果是月末息则存放每月利息的固定金额
     */
    private BigDecimal interestAmount;
    /**
     * 这个值只放按固定金额收取的服务费的金额，如果是月头息则存放第0期应还服务费的固定金额，如果是月末息则存放每月服务费的固定金额
     */
    private BigDecimal serviceAmount;
    /**
     * 账单类型
     */
    private Integer billType;
}
