package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultTestTableVO {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("SOURCE")
    private Integer source;

    public ResultTestTableVO(Integer id, String name, Integer source) {

        this.id = id;
        this.name = name;
        this.source = source;
    }
}
