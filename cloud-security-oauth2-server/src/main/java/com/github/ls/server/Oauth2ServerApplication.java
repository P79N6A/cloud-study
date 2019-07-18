package com.github.ls.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/** @author liang */
@SpringBootApplication
@EntityScan(basePackages = "com.github.ls")
public class Oauth2ServerApplication {

  public static void main(String[] args) {
    System.setProperty("hibernate.dialect.storage_engine", "innodb");
    SpringApplication.run(Oauth2ServerApplication.class, args);
  }
}
