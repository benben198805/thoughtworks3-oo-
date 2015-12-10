package com.thoughtworks.pos.format;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ben on 15-12-9.
 */
public class Format {
    private List<String> formatTarget;

    public void setFormatTarget(List<String> formatTarget) {
        this.formatTarget = formatTarget;
    }

    public List<String> getFormatTarget() {
        return formatTarget;
    }

    public HashMap<String,Double> getFormatResult(){
        HashMap<String,Double> result=new HashMap<>();
        return result;
    }
}
