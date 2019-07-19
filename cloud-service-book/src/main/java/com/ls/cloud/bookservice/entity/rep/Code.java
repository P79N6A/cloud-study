package com.ls.cloud.bookservice.entity.rep;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum Code {

    SUCCESS(200),
    FAIL(500);

    private int code;

    Code(int code) {
        this.code = code;
    }

}