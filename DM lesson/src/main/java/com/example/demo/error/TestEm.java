package com.example.demo.error;

import lombok.Getter;

@Getter
public enum TestEm {

    RECORD_NOT_EXIST(1, "记录不存在");

    private Integer code;
    private String message;

    TestEm(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
