package com.ls.cloud.wxservice.controller;

import com.ls.cloud.wxservice.utils.Conast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liang
 */
@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/")
    public String index() {
        return restTemplate.getForEntity(Conast.BOOK_SERVICE_URL + "myBook/1", String.class).getBody();
    }
}
