package com.thoughtworks.pos;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PosMachineTest {
    private PosMachine posMachine;
    private List<String> emptyList;

    @Before
    public void setUp()
    {
        emptyList=new ArrayList<>();
    }

    @Test
    public void should_return_0_when_shopping_cart_empty() {
        List<String> emptyCart = Arrays.asList();

        posMachine=new PosMachine(emptyCart,emptyList,emptyList,emptyList);
        double total = posMachine.calculate();

        assertThat(total, is(0d));
    }


    @Test
    public void should_return_0_when_shopping_cart_when_someItem_without_price() {
        List<String> carts = Arrays.asList("ITEM000001-3","ITEM000003-3", "ITEM000005-2");
        List<String> itemList = Arrays.asList("ITEM000001:40", "ITEM000005:60");

        posMachine=new PosMachine(carts,itemList,emptyList,emptyList);
        try {
            double total = posMachine.calculate();
        }
        catch (IllegalArgumentException e){
            MatcherAssert.assertThat(e.getMessage(),is("some item without price"));
        }
    }

    @Test
    public void should_return_0_when_shopping_cart_without_any_promotion() {
        List<String> carts = Arrays.asList("ITEM000001-3","ITEM000003-3", "ITEM000005-2");
        List<String> itemList = Arrays.asList("ITEM000001:40","ITEM000003:50", "ITEM000005:60");

        posMachine=new PosMachine(carts,itemList,emptyList,emptyList);
        double total = posMachine.calculate();

        assertThat(total, is(390d));
    }


    @Test
    public void should_return_0_when_shopping_cart_without_secondHalf_promotion() {
        List<String> carts = Arrays.asList("ITEM000001-3","ITEM000003-3", "ITEM000005-2");
        List<String> itemList = Arrays.asList("ITEM000001:40","ITEM000003:50", "ITEM000005:60");
        List<String> discountList = Arrays.asList("ITEM000001:75", "ITEM000005:90");

        posMachine=new PosMachine(carts,itemList,discountList,emptyList);
        double total = posMachine.calculate();

        assertThat(total, is(348d));
    }


    @Test
    public void should_return_0_when_shopping_cart_without_discount_promotion() {
        List<String> carts = Arrays.asList("ITEM000001-3","ITEM000003-3", "ITEM000005-2");
        List<String> itemList = Arrays.asList("ITEM000001:40","ITEM000003:50", "ITEM000005:60");
        List<String> secondHalfPriceLists = Arrays.asList("ITEM000001", "ITEM000005");

        posMachine=new PosMachine(carts,itemList,emptyList,secondHalfPriceLists);
        double total = posMachine.calculate();

        assertThat(total, is(340d));
    }


    @Test
    public void should_return_0_when_shopping_cart_with_promotion() {
        List<String> carts = Arrays.asList("ITEM000001-3","ITEM000003-3", "ITEM000005-2");
        List<String> itemList = Arrays.asList("ITEM000001:40","ITEM000003:50", "ITEM000005:60");
        List<String> discountList = Arrays.asList("ITEM000001:75", "ITEM000005:90");
        List<String> secondHalfPriceLists = Arrays.asList("ITEM000001", "ITEM000005");

        posMachine=new PosMachine(carts,itemList,discountList,secondHalfPriceLists);
        double total = posMachine.calculate();

        assertThat(total, is(306d));
    }
}