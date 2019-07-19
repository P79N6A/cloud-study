package com.github.ls.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/** @author liang */
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2BlogApplication {

  public static void main(String[] args) {
    System.setProperty("hibernate.dialect.storage_engine", "innodb");
    SpringApplication.run(Oauth2BlogApplication.class, args);
  }
}
