package com.process.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RedisListVO<T> {

    @JsonProperty("list")
    List<T> redisVOS = new ArrayList<>();
}
