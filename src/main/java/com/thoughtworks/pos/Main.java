package com.thoughtworks.pos;

public class Main {
    public static void main(String[] args) {
        double total=0.0d;
        PosMachine posMachine=new PosMachine(ShopData.cart,ShopData.itemList,ShopData.discountPromotion,ShopData.secondHalfPricePromotion);
        total=posMachine.calculate();

        System.out.println("总价:" + total);
    }
}
