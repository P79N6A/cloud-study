package com.ls.cloud.bookservice.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * 书架
 *
 * @author liang
 */
@Data
public class MyBook implements Serializable {

    private int id;

    private String openId;

    private int bookId;

    private String bookName;

    private String bookAuthor;

    private String bookTitle;

    private String bookOrder;

}
