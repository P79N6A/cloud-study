package com.github.ls.bill.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.hystrix.FallbackHandler;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

  @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
  public String echo(@PathVariable String string) {
    return "Hello Nacos Discovery " + string;
  }

  @HystrixCommand(fallbackMethod = "t2")
  @GetMapping("/t1")
  public String t1() {
    long l = System.currentTimeMillis();
    System.out.println("###" + l);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
    }
    return "abc";
  }

  @GetMapping("/t2")
  public String t2() {
    return "time out";
  }
}
