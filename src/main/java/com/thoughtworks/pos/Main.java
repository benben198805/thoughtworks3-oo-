package com.thoughtworks.pos;

import com.thoughtworks.pos.format.Format;
import com.thoughtworks.pos.format.FormatFactory;
import com.thoughtworks.pos.good.DiscountPromotion;
import com.thoughtworks.pos.good.Good;
import com.thoughtworks.pos.good.SecondHalfPromotion;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Format cartFormat=new FormatFactory().statrFormat("-",ShopData.cart);
        HashMap<String,Double> carts=cartFormat.getFormatResult();

        Format secondHalfPriceItemFormat=new FormatFactory().statrFormat(" ",ShopData.secondHalfPricePromotion);
        HashMap<String,Double> secondHalfPriceItems=secondHalfPriceItemFormat.getFormatResult();

        Format discountItemFormat=new FormatFactory().statrFormat(":",ShopData.discountPromotion);
        HashMap<String,Double> discountItems=discountItemFormat.getFormatResult();

        Format itemListFormat=new FormatFactory().statrFormat(":",ShopData.itemList);
        HashMap<String,Double> itemList=itemListFormat.getFormatResult();

        double total=0.0d;
        Iterator iter=carts.keySet().iterator();
        while (iter.hasNext())
        {
            String goodCode=iter.next().toString();
            double goodPrice=itemList.get(goodCode);
            Good good=new Good(goodCode,carts.get(goodCode).intValue(),goodPrice);

            if(discountItems.containsKey(goodCode)){
                double discountRate=discountItems.get(goodCode)*0.01;
                DiscountPromotion discount=new DiscountPromotion(discountRate);
                discount.setPromotion(good);
//                discount.calTotalPrice();
            }

            if(secondHalfPriceItems.containsKey(goodCode))
            {

                SecondHalfPromotion secondHalf=new SecondHalfPromotion();
                secondHalf.setPromotion(good);
//                secondHalf.calTotalPrice();
            }


            total+=good.getTotalPrice();
        }

        System.out.println(total);


//        ItemParser itemParser = new ItemParser();
//        List<Item> allItems = itemParser.parse(ShopData.ITEMS_DATA);
//        ShoppingCartParser shoppingCartParser = new ShoppingCartParser();
//        List<CartItem> cartItems = shoppingCartParser.parse(ShopData.SHOPPING_CART_DATA);
//
//        PosMachine posMachine = new PosMachine(allItems);
//        double total = posMachine.calculate(cartItems);
//
//        System.out.println("总价:" + total);
    }
}
