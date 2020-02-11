package com.example.demo.Exception;

import com.example.demo.error.TestEm;

public class TestException extends RuntimeException{

    public TestException(TestEm testEm){

        super(testEm.getMessage());
        code = testEm.getCode();
    }

    private Integer code;
}
