package com.example.demo.service;

import com.example.demo.object.TestDemo;
import com.example.demo.repository.TestDemoRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDemoService {

    @Autowired
    TestDemoRepository repository;

    public List<TestDemo> getAll(){

        return repository.findAll();
    }

    public List<TestDemo> getLimitedData(Integer pageNum, Integer size){

        pageNum = (pageNum - 1) * size;
        return repository.getLimitedData(pageNum, size);
    }
}
