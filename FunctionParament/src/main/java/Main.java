public class Main {

    public static void main(String args[]) {

        int intFunctionValue = 100;
        intFunction(100);
        System.out.println("Main functionValue : " + intFunctionValue);
        System.out.println("---------- 华丽的分割线 ----------");

        Integer IntegerFunctionValue = new Integer(100);
        IntegerFunction(IntegerFunctionValue);
        System.out.println("Main IntegerFunction : " + IntegerFunctionValue);
        System.out.println("---------- 华丽的分割线 ----------");

        Struct struct = new Struct();
        struct.setAge(17);
        struct.setName("heheda");
        ClassFunction(struct);
        System.out.println("Main ClassFunction : " + struct);
        System.out.println("---------- 华丽的分割线 ----------");
    }

    static void intFunction(int value){

        value = 200;
        System.out.println("intFunction value : " + value);
    }

    static void IntegerFunction(Integer value){

        value = 200;
        System.out.println("IntegerFunction value : " + value);
    }

    static void ClassFunction(Struct value){

        value.setAge(18);
        value.setName("Hello World");
        System.out.println("ClassFunction value : " + value);
    }

    static class Struct{

        private Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Struct{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
