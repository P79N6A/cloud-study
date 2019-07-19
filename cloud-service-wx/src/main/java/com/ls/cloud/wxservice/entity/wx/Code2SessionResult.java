package com.ls.cloud.wxservice.entity.wx;

import lombok.Data;

import java.io.Serializable;

/**
 * code2Session 接口返回数据
 */
@Data
public class Code2SessionResult implements Serializable {

    private String openid;

    private String session_key;

    private String unionid;

    private Integer errcode;

    private String errMsg;

}
