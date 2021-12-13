package com.feng.springboot.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 展示商品搜索列表视图VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopcartVO {
    private String itemId;
    private String itemName;
    private String itemImgUrl;
    private String specId;
    private String specName;
    private String priceNormal;
    private String priceDiscount;

}
