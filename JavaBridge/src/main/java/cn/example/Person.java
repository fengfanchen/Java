package cn.example;

public abstract class Person {

    protected Weapon weapon;

    protected Person(Weapon weapon) {

        this.weapon = weapon;
    }

    public void todoSomething(){

        weapon.attack();
    }

    public void changeWeapon(Weapon weapon){

        this.weapon = weapon;
    }
}
