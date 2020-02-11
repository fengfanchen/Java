package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ResultTestTableListVO {

    @JsonProperty("DATA")
    List<ResultTestTableVO> list = new ArrayList<>();
}
