package com.example.qlbhcdio.model;

public class SettingFunction {
    int id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SettingFunction(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
