package com.example.demo.service.imple;

import com.example.demo.object.TestTable;
import com.example.demo.repository.TestTableRepository;
import com.example.demo.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTableServiceImple implements TestTableService {

    @Autowired
    TestTableRepository repository;

    @Override
    public List<TestTable> getAllData() {

        return repository.findAll();
    }

    @Override
    public TestTable getTestTableByID(Integer id) {

//        TestTable one = repository.findById(id).get();

        List<TestTable> all = repository.findAll();

        for(TestTable testTable : all){

            if(testTable.getId() == id){

                return testTable;
            }
        }

        return null;
    }
}
