package com.thoughtworks.pos.format;

import com.thoughtworks.pos.ShopData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ben on 15-12-9.
 */
public class FormatNormalTest {
    private Format format;

    @Test
    public void should_return_hashMap_given_correctData_when_use_getFormatResult(){
        format=new FormatFactory().statrFormat(" ", ShopData.secondHalfPricePromotion);

        HashMap<String,Double> result=format.getFormatResult();

        assertThat(result.size(),is(2));
        assertThat(result.get("ITEM000001"),is(0.0));
        assertThat(result.get("ITEM000003"),is(0.0));
    }

    @Test
    public void should_return_null_given_zerotData_when_use_getFormatResult(){
        List<String> itemList=new ArrayList<>();
        format=new FormatFactory().statrFormat(":",itemList);

        HashMap<String,Double> result=format.getFormatResult();

        assertThat(result.size(),is(0));
    }

}