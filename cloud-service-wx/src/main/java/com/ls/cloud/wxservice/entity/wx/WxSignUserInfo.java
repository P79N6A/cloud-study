package com.ls.cloud.wxservice.entity.wx;

import lombok.Data;

@Data
public class WxSignUserInfo {

    private String errMsg;

    private String rawData;

    private UserInfo userInfo;

    private String signature;

    private String encryptedData;

    private String iv;


}
