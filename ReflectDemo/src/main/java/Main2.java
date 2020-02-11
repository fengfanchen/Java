import Object.Person;

import java.lang.reflect.Field;

public class Main2 {

    public static void main(String[] args) throws Exception {

        //Field[] getFields()获取所有public修饰的成员变量
        Class aClass = Class.forName("Object.Person");
        Field[] fields = aClass.getFields();
        for(Field field : fields){

            System.out.println(field);
        }

        //获取及设置a的值
        Field a = aClass.getField("a");

        Person person = new Person();
        Object value = a.get(person);
        System.out.println("the a is : " + value);
        a.set(person, "你妹");
        System.out.println(person);

        System.out.println("----------华丽的分割线----------");

        //Field getDeclaredField(String name)
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field : declaredFields){

            System.out.println(field);
        }

        //忽略修饰符暴力反射，设置值
        Field d = aClass.getDeclaredField("d");
        d.setAccessible(true);
        d.set(person, "猪小明");
        System.out.println(person);
    }
}
