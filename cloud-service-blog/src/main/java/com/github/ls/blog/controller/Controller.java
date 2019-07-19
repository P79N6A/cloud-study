package com.github.ls.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

  @GetMapping("/")
  public List<Integer> list() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(1);
    list.add(1);
    list.add(1);
    return list;
  }
}
