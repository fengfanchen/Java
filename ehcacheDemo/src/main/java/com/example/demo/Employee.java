package com.example.demo;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private String role;

    public Employee() {
    }

    public Employee(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

}
