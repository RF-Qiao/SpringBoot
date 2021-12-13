package com.feng.springboot.entity.Vo;

import com.feng.springboot.entity.Items;
import com.feng.springboot.entity.ItemsImg;
import com.feng.springboot.entity.ItemsParam;
import com.feng.springboot.entity.ItemsSpec;

import java.util.List;

public class ItemInfoVO {
    private Items items;
    private List<ItemsImg> itemsImg;
    private List<ItemsSpec> itemsSpec;
    private ItemsParam itemsParam;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<ItemsImg> getItemsImg() {
        return itemsImg;
    }

    public void setItemsImg(List<ItemsImg> itemsImg) {
        this.itemsImg = itemsImg;
    }

    public List<ItemsSpec> getItemsSpec() {
        return itemsSpec;
    }

    public void setItemsSpec(List<ItemsSpec> itemsSpec) {
        this.itemsSpec = itemsSpec;
    }

    public ItemsParam getItemsParam() {
        return itemsParam;
    }

    public void setItemsParam(ItemsParam itemsParam) {
        this.itemsParam = itemsParam;
    }
}
