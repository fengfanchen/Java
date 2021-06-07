package cn.example;

public class Gun implements Weapon {

    private String name;
    private Integer value;
    private Integer scope;

    public Gun(String name, Integer value, Integer scope) {

        this.name = name;
        this.value = value;
        this.scope = scope;
    }

    public void attack() {

        System.out.println(this + ", name:" + name +  ", value:" + value + ", scope:" + scope);
    }
}
