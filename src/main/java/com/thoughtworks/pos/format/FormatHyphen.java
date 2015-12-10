package com.thoughtworks.pos.format;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 15-12-9.
 */
public class FormatHyphen extends Format {
    private String regex="^\\w:\\d$";
    public FormatHyphen(List<String> formatTarget) {
        super(formatTarget);
    }

    @Override
    public HashMap<String, Double> getFormatResult() {
        List<String> items=super.getFormatTarget();

        Pattern r=Pattern.compile(regex);

        HashMap<String, Double> result=null;

        for (String item:items) {
            Matcher m=r.matcher(item);
            if(!m.find())
            {
                throw new IllegalArgumentException("bad format item"+item);
            }

            String[] itemArr=item.split(":");
            result.put(itemArr[0],Double.valueOf(itemArr[1]));
        }

        return result;
    }
}
