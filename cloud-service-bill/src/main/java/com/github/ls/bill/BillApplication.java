package com.github.ls.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BillApplication {

  public static void main(String[] args) {
    System.setProperty("hibernate.dialect.storage_engine", "innodb");
    SpringApplication.run(BillApplication.class, args);
  }
}
