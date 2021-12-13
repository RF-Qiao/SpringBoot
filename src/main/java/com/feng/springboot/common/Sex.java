package com.feng.springboot.common;

/**
 * 性别的枚举
 */
public enum Sex {
    Woman(0,"女"),
    Man(1,"男"),
    Secret(2,"保密");
    public final Integer Type;
    public final String VALUE;

    Sex(Integer type, String VALUE) {
        Type = type;
        this.VALUE = VALUE;
    }
}
