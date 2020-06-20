package com.example.qlbhcdio.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("TENDN")
    @Expose
    private String tENDN;
    @SerializedName("MATKHAU")
    @Expose
    private String mATKHAU;
    @SerializedName("TENKH")
    @Expose
    private String tENKH;
    @SerializedName("SDT")
    @Expose
    private String sDT;
    @SerializedName("LOAITK")
    @Expose
    private Integer lOAITK;

    public User(String tENDN, String mATKHAU) {
        this.tENDN = tENDN;
        this.mATKHAU = mATKHAU;
    }

    public User(String tENDN, String mATKHAU, String tENKH, String sDT, Integer lOAITK) {
        this.tENDN = tENDN;
        this.mATKHAU = mATKHAU;
        this.tENKH = tENKH;
        this.sDT = sDT;
        this.lOAITK = lOAITK;
    }

    public String getTENDN() {
        return tENDN;
    }

    public void setTENDN(String tENDN) {
        this.tENDN = tENDN;
    }

    public String getMATKHAU() {
        return mATKHAU;
    }

    public void setMATKHAU(String mATKHAU) {
        this.mATKHAU = mATKHAU;
    }

    public String getTENKH() {
        return tENKH;
    }

    public void setTENKH(String tENKH) {
        this.tENKH = tENKH;
    }

    public String getSDT() {
        return sDT;
    }

    public void setSDT(String sDT) {
        this.sDT = sDT;
    }

    public Integer getLOAITK() {
        return lOAITK;
    }

    public void setLOAITK(Integer lOAITK) {
        this.lOAITK = lOAITK;
    }

}