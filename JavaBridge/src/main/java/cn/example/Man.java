package cn.example;

public class Man extends Person{

    public Man(Weapon weapon) {

        super(weapon);
    }

    @Override
    public void todoSomething() {

        weapon.attack();
    }
}
