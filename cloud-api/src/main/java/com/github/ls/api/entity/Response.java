package com.github.ls.api.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

  private int code;

  private T obj;
}
