package com.example.qlbhcdio.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Detail {
    private String id;
    private double money;
    private String idProduct;
    private Date dateTime;
    private int amount;

    public Detail(String id, double money, String idProduct, String dateTime, int amount) throws ParseException {
        this.id = id;
        this.money = money;
        this.idProduct = idProduct;
        this.dateTime = StringToDate(dateTime);
        this.amount = amount;
    }

    public Detail(String id, double money, String dateTime) throws ParseException {
        this.id = id;
        this.money = money;
        this.dateTime = StringToDate(dateTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTimeString() {
        return DateToString(this.dateTime);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String DateToString(Date dateTime) {
        return new SimpleDateFormat("dd/mm/yyyy").format(dateTime);
    }

    public Date StringToDate(String dateTime) throws ParseException {
        return new SimpleDateFormat("dd/mm/yyyy").parse(dateTime);
    }


}
