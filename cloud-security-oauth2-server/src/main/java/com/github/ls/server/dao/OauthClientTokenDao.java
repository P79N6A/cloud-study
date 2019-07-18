package com.github.ls.server.dao;

import com.github.ls.server.entity.OauthClientToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientTokenDao extends JpaRepository<OauthClientToken, String> {}
