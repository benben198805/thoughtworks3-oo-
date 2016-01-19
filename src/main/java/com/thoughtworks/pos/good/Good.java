package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public class Good{
    private String goodCode;
    private int goodNumber;
    private double goodPrice;
    private double totalPrice;
    private double discount;
    private boolean isSecondHalf;


    public Good(String goodCode, int goodNumber, double goodPrice, double discount, boolean isSecondHalf) {
        this.goodCode = goodCode;
        this.goodNumber = goodNumber;
        this.goodPrice = goodPrice;
        this.discount = discount;
        this.isSecondHalf = isSecondHalf;
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

    public double getDiscount() {
        return discount;
    }

    public boolean isSecondHalf() {
        return isSecondHalf;
    }

    public double calTotalPrice(){
        totalPrice=goodNumber*goodPrice;
        Promotions discountPromotion=new DiscountPromotion(this);
        discountPromotion.doPromotions();

        Promotions secondHalfPromotion=new SecondHalfPromotion(this);
        secondHalfPromotion.doPromotions();

        return totalPrice;

    }
}
