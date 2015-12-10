package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public abstract class Promotions extends Good {
    protected Good good;

    public void setPromotion(Good good){
        this.good=good;
        calTotalPrice();
    }

    @Override
    public void calTotalPrice() {
        if (good != null)
        {
            super.calTotalPrice();
        }
    }

}
