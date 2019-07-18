package com.github.ls.server.service;

import com.github.ls.server.entity.SysMenu;
import com.github.ls.server.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysServiceTest {

  @Autowired private SysService sysService;

  @Test
  public void findUserByUsername() {
    SysUser admin = sysService.findUserByUsername("admin");
    Assert.assertNotEquals(admin, null);
    System.out.println(admin.getName());
  }

  @Test
  public void findMenusByUsername() {
    List<SysMenu> list = sysService.findMenusByUsername("admin");
    Assert.assertNotEquals(list, null);
    Assert.assertNotEquals(list.size(), 0);
    System.out.println(list.get(0).getName());
  }
}
