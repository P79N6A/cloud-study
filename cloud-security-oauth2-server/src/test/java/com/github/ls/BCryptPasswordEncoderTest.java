package com.github.ls;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

  @Test
  public void t0() {
    String secret = new BCryptPasswordEncoder().encode("secret");
    String pwd = new BCryptPasswordEncoder().encode("123456");
    System.out.println(secret);
    System.out.println(pwd);
  }
}
