package com.github.ls.cloudregistereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudRegisterEurekaApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudRegisterEurekaApplication.class, args);
  }
}
