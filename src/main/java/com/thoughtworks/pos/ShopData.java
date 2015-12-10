package com.thoughtworks.pos;

import java.util.Arrays;
import java.util.List;

public final class ShopData {
    public static final List<String> itemList =
            Arrays.asList("ITEM000001:40","ITEM000001:50", "ITEM000005:60");

    public static final List<String> discountPromotion =
            Arrays.asList("ITEM000001:75", "ITEM000005:90");

    public static final List<String> hecondHalfPricePromotion =
            Arrays.asList("ITEM000001", "ITEM000003");

    public static final List<String> cart =
            Arrays.asList("ITEM000001-3","ITEM000001-2", "ITEM000005-2");
}
