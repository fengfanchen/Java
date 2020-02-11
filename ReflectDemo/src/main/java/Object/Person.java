package Object;

public class Person {

    private String name;
    private Integer age;

    public String a;
    protected String b;
    String c;
    private String d;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat(){

        System.out.println("eat... ...");
    }

    //带参数的
    public void eat(String food){

        System.out.println("eat... ..." + food);
    }
}
