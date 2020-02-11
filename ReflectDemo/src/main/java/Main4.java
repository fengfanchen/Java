import Object.Person;

import java.lang.reflect.Method;

public class Main4 {

    public static void main(String[] args) throws Exception {

        Class personClass = Person.class;

        //获取指定名称的方法
        Method eat = personClass.getMethod("eat");
        Person p = new Person();
        eat.invoke(p);

        System.out.println("----------华丽的风格线----------");
        Method eat1 = personClass.getMethod("eat", String.class);
        eat1.invoke(p, "西北风");

        //获取所有Public修饰的方法
        Method[] methods = personClass.getMethods();
        for(Method method : methods){

            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
            //method.setAccessible(true);
        }
    }
}
