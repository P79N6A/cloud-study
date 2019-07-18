package com.github.ls.server.dao;

import com.github.ls.server.entity.OauthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthCodeDao extends JpaRepository<OauthCode, String> {}
