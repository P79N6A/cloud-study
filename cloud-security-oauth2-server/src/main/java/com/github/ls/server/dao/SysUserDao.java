package com.github.ls.server.dao;

import com.github.ls.server.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, String> {
  SysUser findByUsername(String username);
}
