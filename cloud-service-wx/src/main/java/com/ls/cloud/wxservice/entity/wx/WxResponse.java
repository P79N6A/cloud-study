package com.ls.cloud.wxservice.entity.wx;

import lombok.Data;

@Data
public class WxResponse {

    /**
     * 0 成功
     */
    private int errcode;

    private String errmsg;
}
