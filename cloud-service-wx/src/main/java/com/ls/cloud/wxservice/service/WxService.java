package com.ls.cloud.wxservice.service;

import com.ls.cloud.wxservice.entity.wx.Code2SessionResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;

@Service
public class WxService {

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取Code2Session
     *
     * @param code
     * 4
     * 
     * @throws Exception
     */
    public Optional<Code2SessionResult> getCode2Session(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret="
                + secret + "&js_code=" + code + "&grant_type=authorization_code";;
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
