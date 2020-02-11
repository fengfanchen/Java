package com.example.demo.service.imple;

import com.example.demo.object.TestTable;
import com.example.demo.service.TestTableService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestTableServiceImpleTest {

    @Autowired
    TestTableService service;

    @Test
    void getAllData() {

        System.out.println(service.getAllData());
    }

    @Test
    void getTestTableByID() {

        TestTable testTableByID = service.getTestTableByID(2);
        System.out.println(testTableByID);
    }
}