package com.process.demo.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    private Integer code;
    private String msg;
    T data;
}
