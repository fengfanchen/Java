package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@EnableCaching
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Employee> listOfEmployees = employeeService.getListOfEmployees();
        System.out.println(listOfEmployees);
        System.out.println("---------------------------------------------------");

        listOfEmployees = employeeService.getListOfEmployees();
        System.out.println(listOfEmployees);
        System.out.println("---------------------------------------------------");

        Employee employee = employeeService.findEmployeeByName("Sumit", listOfEmployees);
        System.out.println(employee);
        System.out.println("---------------------------------------------------");

        employee = employeeService.findEmployeeByName("Sumit", listOfEmployees);
        System.out.println(employee);
        System.out.println("---------------------------------------------------");

        employee = employeeService.findEmployeeByName("Liton", listOfEmployees);
        System.out.println(employee);
        System.out.println("---------------------------------------------------");
    }
}
