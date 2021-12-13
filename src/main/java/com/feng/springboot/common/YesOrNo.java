package com.feng.springboot.common;

public enum YesOrNo {
    NO(0,"否"),
    YES(1,"是");

    public final Integer Type;
    public final String VALUE;

    YesOrNo(Integer type, String VALUE) {
        Type = type;
        this.VALUE = VALUE;

    }
}