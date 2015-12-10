package com.thoughtworks.pos.format;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ben on 15-12-9.
 */
public class FormatNormal extends Format {
    @Override
    public HashMap<String, Double> getFormatResult() {
        List<String> items=super.getFormatTarget();


        HashMap<String, Double> result=new HashMap<>();

        for (String item:items) {
            result.put(item,0.0d);
        }

        return result;
    }
}
