package com.github.ls.server.dao;

import com.github.ls.server.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysMenuDao extends JpaRepository<SysMenu, Integer> {
    List<SysMenu> findByUsername(String username);
}
