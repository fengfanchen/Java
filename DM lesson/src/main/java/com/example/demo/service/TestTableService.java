package com.example.demo.service;

import com.example.demo.object.TestTable;

import java.util.List;

public interface TestTableService {

    List<TestTable> getAllData();

    TestTable getTestTableByID(Integer id);
}
