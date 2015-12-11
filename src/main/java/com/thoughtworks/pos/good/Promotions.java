package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public abstract class Promotions{
    protected Good good;

    public Promotions(Good good) {
        this.good = good;
    }
//
//    public void calTotalPrice() {
//        doPromotions();
//    }

    public abstract void doPromotions();
}
