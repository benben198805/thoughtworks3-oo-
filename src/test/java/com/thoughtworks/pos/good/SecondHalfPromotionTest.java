package com.thoughtworks.pos.good;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ben on 15-12-10.
 */
public class SecondHalfPromotionTest {
    private Good good;

    @Test
    public void should_return_100$_pursure_three_thing_with_40$(){
        good=new Good("ITEM000003",3,40);
        Promotions promotions=new SecondHalfPromotion(good);
        promotions.doPromotions();
        double total=good.getTotalPrice();

        assertThat(total,is(100d));
    }

    @Test
    public void should_return_60$_pursure_two_thing_with_40$(){
        good=new Good("ITEM000003",2,40);

        Promotions promotions=new SecondHalfPromotion(good);
        promotions.doPromotions();
        double total=good.getTotalPrice();

        assertThat(total,is(60d));
    }

}