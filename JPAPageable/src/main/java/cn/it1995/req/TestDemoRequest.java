package cn.it1995.req;

import lombok.Data;

@Data
public class TestDemoRequest extends PageRequest {

    private long id;
    private String value1;
}