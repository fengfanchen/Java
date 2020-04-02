package com.example.demo.repository;

import com.example.demo.object.TestDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDemoRepository extends JpaRepository<TestDemo, Integer> {

    @Query(value = "select * from test_demo limit ?1, ?2", nativeQuery = true)
    List<TestDemo> getLimitedData(Integer pageNum, Integer size);
}
