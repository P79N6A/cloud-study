package com.github.ls.server.dao;

import com.github.ls.server.entity.OauthRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthRefreshTokenDao extends JpaRepository<OauthRefreshToken, String> {}
