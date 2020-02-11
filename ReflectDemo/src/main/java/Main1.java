import Object.Person;

public class Main1 {

    public static void main(String[] args) throws ClassNotFoundException {

        //全类名
        Class cls1 = Class.forName("Object.Person");
        System.out.println(cls1);

        //类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);

        //对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //比较下对象：
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }
}
