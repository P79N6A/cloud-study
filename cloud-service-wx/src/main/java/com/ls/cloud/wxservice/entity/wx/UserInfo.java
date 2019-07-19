package com.ls.cloud.wxservice.entity.wx;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {


    /**
     * openId : OPENID
     * nickName : NICKNAME
     * gender : GENDER
     * city : CITY
     * province : PROVINCE
     * country : COUNTRY
     * avatarUrl : AVATARURL
     * unionId : UNIONID
     * watermark : {"appid":"APPID","timestamp":"TIMESTAMP"}
     */

    private String openId;
    private String nickName;
    private String gender;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private WatermarkBean watermark;

    /**
     * 验证码
     */
    private String invitation_code;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 令牌
     */
    private String token;

    /**
     * wx.login 接口 用户登录凭证（有效期五分钟）。
     * 开发者需要在开发者服务器后台调用 code2Session，使用 code 换取 openid 和 session_key 等信息
     */
    private String code;

    /**
     * formId
     */
    private String formId;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行卡号 后四位
     */
    private String bankCard;

    @Data
    public static class WatermarkBean {

        private String appid;
        private String timestamp;

    }
}
