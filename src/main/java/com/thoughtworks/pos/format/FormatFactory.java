package com.thoughtworks.pos.format;

import java.util.List;

/**
 * Created by ben on 15-12-9.
 */
public class FormatFactory {
    public Format statrFormat(String delimiter,List<String> items){
        Format format=null;
        switch (delimiter)
        {
            case ":":
                format=new FormatColon();
                break;
            case "-":
                format=new FormatHyphen();
                break;
            case " ":
                format=new FormatNormal();
                break;
            default:
                break;

        }
        format.setFormatTarget(items);
        return format;
    }

}
