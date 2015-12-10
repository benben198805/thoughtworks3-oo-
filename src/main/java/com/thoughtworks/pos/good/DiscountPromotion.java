package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public class DiscountPromotion extends Promotions {
    private double discount;

    public DiscountPromotion(Good good,double discount) {
        super(good);
        this.discount=discount;
    }


    @Override
    public void doPromotions() {
        double goodPrice=good.getGoodPrice();
        good.setGoodPrice(goodPrice*discount);

        double total=good.getTotalPrice();
        total= total*discount;
        good.setTotalPrice(total);
    }

}
