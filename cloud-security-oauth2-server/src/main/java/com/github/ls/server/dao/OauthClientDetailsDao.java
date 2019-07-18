package com.github.ls.server.dao;

import com.github.ls.server.entity.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientDetailsDao extends JpaRepository<OauthClientDetails, String> {}
