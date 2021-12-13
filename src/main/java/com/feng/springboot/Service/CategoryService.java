package com.feng.springboot.Service;

import com.feng.springboot.entity.Category;
import com.feng.springboot.entity.Vo.CategoryVo;
import com.feng.springboot.entity.Vo.NewItemsVo;
import com.feng.springboot.entity.Vo.SimpleItemVo;

import java.util.List;

public interface CategoryService {

    List<Category> queryAllRootLevelCat();

    List<CategoryVo> getSubCatList(Integer rootCatId);

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    List<NewItemsVo> getSixNewItemsLazy(Integer rootCatId);
}
