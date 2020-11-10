package com.example.demo.component;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MyShellTest {

    @ShellMethod("Add")
    public Integer add(Integer a, Integer  b){

        return a + b;
    }

    @ShellMethod("print")
    public String print(String name, Integer id){

        String ret = "The name is " + name + ", The id is " + id;
        return ret;
    }
}
