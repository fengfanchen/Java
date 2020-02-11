package main.Exception;

import main.errorEm.ReadFileEm;

public class ReadFileException extends RuntimeException{

    public ReadFileException(ReadFileEm readFileEm){

        super(readFileEm.getMsg());
        this.code = readFileEm.getCode();
    }

    private Integer code;
}
