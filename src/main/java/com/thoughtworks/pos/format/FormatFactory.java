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
                format.setFormatTarget(items);
                break;
            case "-":
                format=new FormatHyphen();
                format.setFormatTarget(items);
                break;
            case " ":
                format=new FormatNormal();
                format.setFormatTarget(items);
                break;
            default:
                break;
        }
        return format;
    }

}
