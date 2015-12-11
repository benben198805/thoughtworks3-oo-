package com.thoughtworks.pos.format;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by ben on 15-12-11.
 */
public class FormatFactoryTest {
    private Format format;
    private List<String> emptyList;

    @Before
    public void setUp() throws Exception {
        emptyList=new ArrayList<>();
    }

    @Test
    public void shoule_return_formatColon_when_use_colon_as_parameter(){
        format=new FormatFactory().statrFormat(":", emptyList);

        assertThat(format instanceof FormatColon,is(true));
    }


    @Test
    public void shoule_return_formatHyphen_when_use_hyphen_as_parameter(){
        format=new FormatFactory().statrFormat("-", emptyList);

        assertThat(format instanceof FormatHyphen,is(true));
    }


    @Test
    public void shoule_return_formatNormal_when_use_space_as_parameter(){
        format=new FormatFactory().statrFormat(" ", emptyList);

        assertThat(format instanceof FormatNormal,is(true));
    }


    @Test
    public void shoule_return_null_when_use_other_as_parameter(){
        format=new FormatFactory().statrFormat("?", emptyList);

        assertThat(format,is(nullValue()));
    }


}