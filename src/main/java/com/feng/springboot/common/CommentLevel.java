package com.feng.springboot.common;

/**
 * 评论等级的枚举类型
 */
public enum CommentLevel {
    GOOD(1,"好"),
    NorMal(2,"中"),
    BAD(3,"差");
    public final Integer Type;
    public final String VALUE;

    CommentLevel(Integer type, String VALUE) {
        Type = type;
        this.VALUE = VALUE;
    }
}
