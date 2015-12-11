package com.thoughtworks.pos;

import com.thoughtworks.pos.format.Format;
import com.thoughtworks.pos.format.FormatFactory;
import com.thoughtworks.pos.good.DiscountPromotion;
import com.thoughtworks.pos.good.Good;
import com.thoughtworks.pos.good.Promotions;
import com.thoughtworks.pos.good.SecondHalfPromotion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class PosMachine {
    private HashMap<String,Double> carts;
    private HashMap<String,Double> itemList;
    private HashMap<String,Double> discountItems;
    private HashMap<String,Double> secondHalfPriceItems;

    private List<String> itemLists;
    private List<String> discountLists;
    private List<String> secondHalfPriceLists;

    public PosMachine(List<String> carts,List<String> itemList,List<String> discountLists,List<String> secondHalfPriceLists) {
        this.carts =setItem(carts);
        this.itemList=setItemList(itemList);
        this.discountItems=setDiscountItems(discountLists);
        this.secondHalfPriceItems=setSecondHalfPriceItems(secondHalfPriceLists);
    }

    private HashMap<String,Double> setItem(List<String> carts){
        Format cartFormat=new FormatFactory().statrFormat("-",carts);
        return cartFormat.getFormatResult();
    }

    private HashMap<String,Double> setItemList(List<String> itemList){
        Format itemListFormat=new FormatFactory().statrFormat(":",itemList);
        return itemListFormat.getFormatResult();
    }

    private HashMap<String,Double> setDiscountItems(List<String> discountLists){
        Format discountItemFormat=new FormatFactory().statrFormat(":",discountLists);
        return discountItemFormat.getFormatResult();
    }

    private HashMap<String,Double> setSecondHalfPriceItems(List<String> secondHalfPriceLists){
        Format secondHalfPriceItemFormat=new FormatFactory().statrFormat(" ",secondHalfPriceLists);
        return secondHalfPriceItemFormat.getFormatResult();
    }

    public double calculate(){
        double total=0.0d;
        Iterator iter=carts.keySet().iterator();
        while (iter.hasNext())
        {
            String goodCode=iter.next().toString();

            if(!itemList.containsKey(goodCode)){
                throw new IllegalArgumentException("some item without price");
            }
            double goodPrice=itemList.get(goodCode);

            Good good=new Good(goodCode,carts.get(goodCode).intValue(),goodPrice);

            doDiscountPromotion(goodCode, good);

            doSecondHalfProtion(goodCode, good);

            total+=good.getTotalPrice();
        }
        return total;
    }

    private void doSecondHalfProtion(String goodCode, Good good) {
        if(secondHalfPriceItems.containsKey(goodCode))
        {
            Promotions secondHalf=new SecondHalfPromotion(good);
            secondHalf.doPromotions();
        }
    }

    private void doDiscountPromotion(String goodCode, Good good) {
        if(discountItems.containsKey(goodCode)){
            double discountRate=discountItems.get(goodCode)*0.01;
            Promotions discount=new DiscountPromotion(good,discountRate);
            discount.doPromotions();
        }
    }


}
