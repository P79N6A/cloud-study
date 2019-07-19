package com.ls.cloud.wxservice.entity.wx;

import lombok.Data;

/**
 * wx access_token
 */
@Data
public class AccessToken {

    /**
     * 获取到的凭证
     */
    private String access_token;

    /**
     * 凭证有效时间，单位：秒
     */
    private long expires_in;

    /**
     * 错误码 0	请求成功
     */
    private int errcode;

    /**
     * 错误信息
     */
    private String errmsg;
}
