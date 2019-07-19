package com.github.ls.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired private DiscoveryClient discoveryClient;

  @GetMapping("/")
  public String ac() {
    return discoveryClient.getServices().get(0).toString();
  }

}
