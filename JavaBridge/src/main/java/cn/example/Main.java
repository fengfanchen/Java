package cn.example;

public class Main {

    public static void main(String[] args) {

        System.out.println("start ...... ...... ......");

        System.out.println("Jack和Tom一人一把黄金装备");
        Sword gold_sword = new Sword("Gold Sword", 100, 2);
        Gun gold_gun = new Gun("Gold Sword", 80, 6);
        Person Jack = new Man(gold_sword);
        Person Tom = new Man(gold_gun);

        Jack.todoSomething();
        Tom.todoSomething();

        System.out.println("来了一个不带装备的女士");
        Person Sofia = new Woman(null);
        Sofia.changeWeapon(gold_sword);
        System.out.println("换上了黄金剑");
        Sofia.todoSomething();

        System.out.println("换上了黄金枪");
        Sofia.changeWeapon(gold_gun);
        Sofia.todoSomething();

        System.out.println("end ...... ..... ......");
    }
}
