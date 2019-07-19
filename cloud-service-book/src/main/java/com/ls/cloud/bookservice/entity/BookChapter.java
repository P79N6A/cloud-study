package com.ls.cloud.bookservice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 章节
 * @author liang
 */
@ApiModel(description = "书籍Model")
@Data
public class BookChapter implements Serializable {

    @ApiModelProperty(value = "表名-no use", name = "tableName")
    private String tableName;

    private String title;

    private String url;

    private String content;

    private int order;

    private String source;

}
