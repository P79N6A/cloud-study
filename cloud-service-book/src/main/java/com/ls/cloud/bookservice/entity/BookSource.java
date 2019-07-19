package com.ls.cloud.bookservice.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 书籍来源
 * @author liang
 */
@Data
public class BookSource implements Serializable {

    private String url;

    private String name;
}
