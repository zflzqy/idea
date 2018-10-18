package com.ssm.di.bean;

import java.util.List;

public class User {
    private int id;

    private String name;

    private List<String> lists;
    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
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
}
