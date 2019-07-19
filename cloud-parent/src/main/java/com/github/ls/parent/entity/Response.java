package com.github.ls.parent.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

  private int code;

  private T obj;
}
