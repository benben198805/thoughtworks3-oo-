package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public class Promotions extends Good {
    protected Good good;

    public Promotions(Good good) {
        this.good = good;
    }

    @Override
    public void calTotalPrice() {
        good.calTotalPrice();
        doPromotions();
    }

    public void doPromotions() {
    }


}
