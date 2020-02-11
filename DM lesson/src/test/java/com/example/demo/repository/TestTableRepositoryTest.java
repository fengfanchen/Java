package com.example.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class TestTableRepositoryTest {


    @Autowired
    TestTableRepository repository;

    @Test
    public void test(){

        System.out.println(repository.findAll());
    }
}