package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public class DiscountPromotion extends Promotions {
    private double discount;

    public DiscountPromotion(Good good) {
        super(good);
        double discount=good.getDiscount();
        this.discount=discount>0&&discount<=1d?discount:1.0d;
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
