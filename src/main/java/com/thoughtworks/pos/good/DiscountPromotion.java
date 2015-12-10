package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public class DiscountPromotion extends Promotions {
    private double discount;

    public DiscountPromotion(double discount) {
        this.discount = discount;
    }

    public DiscountPromotion() {
        this.discount=1.0d;
    }

    @Override
    public void calTotalPrice() {
        double goodPrice=good.getGoodPrice();
        good.setGoodPrice(goodPrice*discount);

        double total=good.getTotalPrice();
        total= total*discount;
        good.setTotalPrice(total);
    }
}
