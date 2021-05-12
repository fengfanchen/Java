package com.example.demo.controller;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.object.EmployeeVO;
import com.example.demo.repository.EmployeeDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MyController {

    @PostMapping(value = "/employees")
    public ResponseEntity<EmployeeVO> addEmployee(@Valid @RequestBody EmployeeVO employeeVO){

        EmployeeDB.addEmployee(employeeVO);
        return new ResponseEntity<EmployeeVO>(employeeVO, HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") Integer id){

        EmployeeVO employeeById = EmployeeDB.getEmployeeById(id);
        if(employeeById == null){

            throw new RecordNotFoundException("Invalid employee id : " + id);
        }

        return new ResponseEntity<EmployeeVO>(employeeById, HttpStatus.OK);
    }
}
