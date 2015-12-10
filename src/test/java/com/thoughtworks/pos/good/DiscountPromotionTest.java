package com.thoughtworks.pos.good;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ben on 15-12-10.
 */
public class DiscountPromotionTest {
    private Good good;
    @Before
    public void setUp()
    {
         good=new Good("ITEM000003",1,40);
    }

    @Test
    public void should_return_30$_pursure_one_thing_with_40$_when_use_75_discount(){
        Promotions promotions=new DiscountPromotion(good,0.75d);
        promotions.calTotalPrice();
        double total=good.getTotalPrice();

        assertThat(total,is(30d));
    }


    @Test
    public void should_return_40$_pursure_one_thing_with_40$_when_use_0_discount(){
        Promotions promotions=new DiscountPromotion(good,0.0d);
        promotions.calTotalPrice();
        double total=good.getTotalPrice();

        assertThat(total,is(40d));
    }


    @Test
    public void should_return_40$_pursure_one_thing_with_40$_when_use_negative_discount(){
        Promotions promotions=new DiscountPromotion(good,-0.75d);
        promotions.calTotalPrice();
        double total=good.getTotalPrice();

        assertThat(total,is(40d));
    }


    @Test
    public void should_return_40$_pursure_one_thing_with_40$_when_use_1_discount(){
        Promotions promotions=new DiscountPromotion(good,1.0d);
        promotions.calTotalPrice();
        double total=good.getTotalPrice();

        assertThat(total,is(40d));
    }


    @Test
    public void should_return_40$_pursure_one_thing_with_40$_when_use_more_than_1_discount(){
        Promotions promotions=new DiscountPromotion(good,1.5d);
        promotions.calTotalPrice();
        double total=good.getTotalPrice();

        assertThat(total,is(40d));
    }



}