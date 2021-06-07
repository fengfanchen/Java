package cn.example;

public class Sword implements Weapon {

    private String name;
    private Integer value;
    private Integer scope;

    public Sword(String name, Integer value, Integer scope) {

        this.name = name;
        this.value = value;
        this.scope = scope;
    }

    public void attack() {

        System.out.println(this + ", name:" + name +  ", value:" + value + ", scope:" + scope);
    }
}
