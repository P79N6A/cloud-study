package com.github.ls.server.dao;

import com.github.ls.server.entity.OauthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthAccessTokenDao extends JpaRepository<OauthAccessToken, String> {}
