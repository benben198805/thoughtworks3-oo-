package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public class Good{
    private String goodCode;
    private int goodNumber;
    private double goodPrice;
    private double totalPrice;

    public Good(String goodCode, int goodNumber, double goodPrice) {
        this.goodCode = goodCode;
        this.goodNumber = goodNumber;
        this.goodPrice = goodPrice;
        this.totalPrice=goodNumber*goodPrice;
    }

    public Good() {
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public void calTotalPrice(){
    }
}
