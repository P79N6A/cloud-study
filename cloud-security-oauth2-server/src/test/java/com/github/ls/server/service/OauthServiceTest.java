package com.github.ls.server.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OauthServiceTest {

  @Autowired private OauthService oauthService;

  @Test
  public void all() {
    System.out.println(oauthService.all());
  }
}
