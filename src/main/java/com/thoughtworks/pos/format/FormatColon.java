package com.thoughtworks.pos.format;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 15-12-9.
 */
public class FormatColon extends Format {
    private String regex="^\\w+:\\d+$";

    @Override
    public HashMap<String, Double> getFormatResult() {
        List<String> items=super.getFormatTarget();

        String[] itemArr;
        Pattern r=Pattern.compile(regex);

        HashMap<String, Double> result=new HashMap<>();

        for (String item:items) {
            Matcher m=r.matcher(item);
            if(!m.matches())
            {
                throw new IllegalArgumentException("bad format item");
            }

            itemArr=item.split(":");
            result.put(itemArr[0],Double.valueOf(itemArr[1]));
        }

        return result;
    }
}
