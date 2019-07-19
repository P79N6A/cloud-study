package com.ls.cloud.bookservice.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 书籍目录
 * @author liang
 */
@Data
public class BookCatalog implements Serializable {

    private int id;

    private String name;

    private String url;

    private String author;

    private String size;

    private String lastUpdate;

    private String lastName;

    private String lastUrl;

    private String status;
}
