package com.example.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Cacheable(value = "employee")
    public List<Employee> getListOfEmployees(){

        System.out.println("getListOfEmployees is running...");

        List<Employee> employees = new ArrayList<Employee>(4);

        employees.add(new Employee(1000, "Sumit", "Manager"));
        employees.add(new Employee(1001, "Souvik", "Java Developer"));
        employees.add(new Employee(1002, "Liton", "SQl Developer"));
        employees.add(new Employee(1003, "Debina", "Leader"));

        return employees;
    }

    @Cacheable(value = "employee", key = "#name")
    public Employee findEmployeeByName(String name, List<Employee> employees) {
        System.out.println("findEmployeeByName is running...");

        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {
                return emp;
            }
        }

        return null;
    }
}