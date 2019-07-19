package com.github.ls.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class FacadeApplication {

  public static void main(String[] args) {
    System.setProperty("hibernate.dialect.storage_engine", "innodb");
    SpringApplication.run(FacadeApplication.class, args);
  }

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
