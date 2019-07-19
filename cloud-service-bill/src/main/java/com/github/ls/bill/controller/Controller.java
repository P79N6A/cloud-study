package com.github.ls.bill.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

  @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
  public String echo(@PathVariable String string) {
    return "Hello Nacos Discovery " + string;
  }
}
