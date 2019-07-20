package com.github.ls.cloudgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

  @Autowired private RestTemplate restTemplate;

  @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
  public String echo(@PathVariable String str) {
    return restTemplate.getForObject("http://cloud-service-bill/echo/" + str, String.class);
  }

  @RequestMapping(value = "/t1", method = RequestMethod.GET)
  public String echo() {
    return restTemplate.getForObject("http://cloud-service-bill/t1/", String.class);
  }
}
