package com.example.demo.vo;

import com.example.demo.error.TestEm;
import lombok.Data;

@Data
public class RecordErrorVO {

    private String msg;

    public RecordErrorVO(String msg) {

        this.msg = msg;
    }

    public RecordErrorVO(TestEm em){

        this.msg = em.getMessage();
    }
}
