package com.byrc.byyc.model;

import java.io.Serializable;

//@Data
public class User implements Serializable {
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setAge(int age) {
        this.age = age;
    }
}
