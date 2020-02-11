package main.errorEm;


import lombok.Getter;

@Getter
public enum ReadFileEm {

    SQL_TEMPLATE_INDEX_ERROR(1,"SQL模板索引格式不对"),
    SQL_TEMPLATE_STRING_ERROR(2, "SQL模板数据格式不对"),
    SQL_LACK_STRING_ERROR(3, "SQL模板格式不对，缺少>");

    private Integer code;
    private String msg;

    ReadFileEm(Integer code, String msg){

        this.code = code;
        this.msg = msg;
    }
}
