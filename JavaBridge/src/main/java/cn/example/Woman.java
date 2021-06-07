package cn.example;

public class Woman extends Person{

    public Woman(Weapon weapon) {

        super(weapon);
    }

    @Override
    public void todoSomething() {

        weapon.attack();
    }
}
