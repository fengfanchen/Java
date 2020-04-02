package com.example.demo.object;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "test_demo", schema = "jap_repository_demo", catalog = "")
public class TestDemo {
    private int id;
    private String name;
    private Integer age;
    private String iphone;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "iphone")
    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestDemo testDemo = (TestDemo) o;
        return id == testDemo.id &&
                Objects.equals(name, testDemo.name) &&
                Objects.equals(age, testDemo.age) &&
                Objects.equals(iphone, testDemo.iphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, iphone);
    }

    @Override
    public String toString() {
        return "TestDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", iphone='" + iphone + '\'' +
                '}';
    }
}
