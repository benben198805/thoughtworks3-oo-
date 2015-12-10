package com.thoughtworks.pos;

import java.util.Arrays;
import java.util.List;

public final class ShopData {
    public static final List<String> itemList =
            Arrays.asList("ITEM000001:40","ITEM000003:50", "ITEM000005:60");

<<<<<<< HEAD
    public static final List<String> ITEMS_DATA =
            Arrays.asList("ITEM000001:40", "ITEM000003:50", "ITEM000005:60");

    public static final List<String> SHOPPING_CART_DATA =
            Arrays.asList("ITEM000001-2", "ITEM000003-5", "ITEM000005-3");
=======
    public static final List<String> discountPromotion =
            Arrays.asList("ITEM000001:75", "ITEM000005:90");

    public static final List<String> secondHalfPricePromotion =
            Arrays.asList("ITEM000001", "ITEM000003");

    public static final List<String> cart =
            Arrays.asList("ITEM000001-3","ITEM000003-2", "ITEM000005-2");
>>>>>>> step2
}
