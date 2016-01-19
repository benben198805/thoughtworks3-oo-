package com.thoughtworks.pos;

import com.thoughtworks.pos.format.Format;
import com.thoughtworks.pos.format.FormatFactory;
import com.thoughtworks.pos.good.Good;

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

            double discount=discountItems.containsKey(goodCode)?discountItems.get(goodCode)/100:1.0d;
            boolean isSecondHalf=secondHalfPriceItems.containsKey(goodCode);

            Good good=new Good(goodCode,carts.get(goodCode).intValue(),goodPrice, discount,isSecondHalf);

            total+=good.calTotalPrice();
        }
        return total;
    }



}
