import Object.Person;

import java.lang.reflect.Constructor;

public class Main3 {

    public static void main(String[] args) throws Exception {

        Class personClass = Person.class;

        Constructor constructor = personClass.getConstructor(String.class, Integer.class);
        System.out.println(constructor);

        //创建对象
        Object p = constructor.newInstance("王二麻子", 99);
        System.out.println(p);

        System.out.println("----------华丽的分割线----------");
        Constructor constructor2 = personClass.getConstructor();
        Object p2 = constructor2.newInstance();
        System.out.println(p2);
    }
}
