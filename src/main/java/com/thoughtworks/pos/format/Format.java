package com.thoughtworks.pos.format;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ben on 15-12-9.
 */
public abstract class Format {
    private List<String> formatTarget;

    public void setFormatTarget(List<String> formatTarget) {
        this.formatTarget = formatTarget;
    }

    public List<String> getFormatTarget() {
        return formatTarget;
    }

    public abstract HashMap<String,Double> getFormatResult();

    protected HashMap<String, Double> decodeTarget(Pattern r,String delimiterSign){
        List<String> items=formatTarget;

        String[] itemArr;

        HashMap<String, Double> result=new HashMap<>();

        for (String item:items) {
            Matcher m=r.matcher(item);
            if(!m.matches())
            {
                throw new IllegalArgumentException("bad format item");
            }

            itemArr=item.split(delimiterSign);
            result.put(itemArr[0],Double.valueOf(itemArr[1]));
        }

        return result;
    }
}
