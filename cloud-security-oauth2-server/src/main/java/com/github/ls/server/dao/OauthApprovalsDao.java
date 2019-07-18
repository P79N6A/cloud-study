package com.github.ls.server.dao;

import com.github.ls.server.entity.OauthApprovals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthApprovalsDao extends JpaRepository<OauthApprovals, String> {}
