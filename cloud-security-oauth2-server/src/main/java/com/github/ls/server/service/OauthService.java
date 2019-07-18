package com.github.ls.server.service;

import com.github.ls.server.dao.OauthClientDetailsDao;
import com.github.ls.server.entity.OauthClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OauthService {

  @Autowired private OauthClientDetailsDao oauthClientDetailsDao;

  public List<OauthClientDetails> all() {
    return oauthClientDetailsDao.findAll();
  }
}
