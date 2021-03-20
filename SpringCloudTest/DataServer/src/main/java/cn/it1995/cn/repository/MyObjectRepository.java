package cn.it1995.cn.repository;

import cn.it1995.cn.object.MyObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MyObjectRepository {

    private  static ArrayList<MyObject> arrayList = new ArrayList<>();

    static {

        MyObject myObject = new MyObject();
        myObject.setId(1);
        myObject.setOne("Hello world");
        myObject.setTwo("How old are you");

        MyObject myObject1 = new MyObject();
        myObject1.setId(2);
        myObject1.setOne("How are you");
        myObject1.setTwo("I am fine, fuck you");

        arrayList.add(myObject);
        arrayList.add(myObject1);
    }

    public ArrayList<MyObject> getAll(){

        return arrayList;
    }

}