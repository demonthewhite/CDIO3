package com.example.qlbhcdio.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("TENDN")
    @Expose
    private String id;
    @SerializedName("MATKHAU")
    @Expose
    private String password;
    @SerializedName("TENKH")
    @Expose
    private String name;
    @SerializedName("SDT")
    @Expose
    private String numPhone;
    @SerializedName("LOAITK")
    @Expose
    private Integer level;
    @SerializedName("DIACHI")
    @Expose
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(String id, String password, String name, String numPhone, Integer level, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.numPhone = numPhone;
        this.level = level;
        this.address = address;
    }
}