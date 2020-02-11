package com.example.demo.service.imple;

import com.example.demo.object.Test;
import com.example.demo.repository.TestRepository;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository repository;

    @Override
    public List<Test> getAllData() {

        return  repository.findAll();
    }
}
