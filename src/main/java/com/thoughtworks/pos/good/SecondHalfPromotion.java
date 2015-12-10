package com.thoughtworks.pos.good;

/**
 * Created by ben on 15-12-9.
 */
public class SecondHalfPromotion extends Promotions{
    @Override
    public void calTotalPrice() {
        int number=good.getGoodNumber();
        double totalPrice=good.getTotalPrice();
        if(number%2==0)
        {
            totalPrice=totalPrice*0.75;
        }
        else
        {
            totalPrice=totalPrice*0.75+good.getGoodPrice()*0.25;
        }
        good.setTotalPrice(totalPrice);

    }
}
