package com.github.ls.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> extends Response<T> implements Serializable {

  private int index;

  private int size;

  private long count;

  private List<T> obj;
}
