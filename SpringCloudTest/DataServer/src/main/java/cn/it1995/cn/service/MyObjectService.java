package cn.it1995.cn.service;

import cn.it1995.cn.object.MyObject;
import cn.it1995.cn.repository.MyObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyObjectService {

    @Autowired
    private MyObjectRepository myObjectRepository;

    public ArrayList<MyObject> getAll(){

        return myObjectRepository.getAll();
    }

    public MyObject getMyObjectById(Integer id){

        ArrayList<MyObject> all = myObjectRepository.getAll();
        for(MyObject object : all){

            if(object.getId().equals(id)){

                return object;
            }
        }

        return null;
    }
}