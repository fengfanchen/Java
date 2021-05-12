package com.example.demo.repository;

import com.example.demo.object.EmployeeVO;

import java.util.ArrayList;

public class EmployeeDB {

    private static ArrayList<EmployeeVO> employeeVOArrayList = new ArrayList<>();

    public static void addEmployee(EmployeeVO employeeVO){

        employeeVOArrayList.add(employeeVO);
    }


    public static EmployeeVO getEmployeeById(Integer id){

        for(EmployeeVO item : employeeVOArrayList){

            if(item.getEmployeeId().equals(id)){

                return item;
            }
        }

        return null;
    }
}
