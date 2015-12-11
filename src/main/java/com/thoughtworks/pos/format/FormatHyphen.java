package com.thoughtworks.pos.format;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by ben on 15-12-9.
 */
public class FormatHyphen extends Format {
    private String regex="^\\w+-\\d+$";
    private String delimiterSign="-";

    @Override
    public HashMap<String, Double> getFormatResult() {
        Pattern r=Pattern.compile(regex);

        HashMap<String, Double> result=super.decodeTarget(r,delimiterSign);

        return result;
    }
}
