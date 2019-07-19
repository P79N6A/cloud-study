package com.ls.cloud.wxservice.controller;

import com.ls.cloud.wxservice.entity.res.DataResponse;
import com.ls.cloud.wxservice.entity.wx.Code2SessionResult;
import com.ls.cloud.wxservice.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author liang
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private WxService wxService;

    @PostMapping("/wxLogin/{code}")
    public DataResponse wxLogin(@PathVariable String code) {
        Optional<Code2SessionResult> code2Session = wxService.getCode2Session(code);
        System.out.println(code2Session.get().toString());
        return DataResponse.SUCCESS();
    }
}
