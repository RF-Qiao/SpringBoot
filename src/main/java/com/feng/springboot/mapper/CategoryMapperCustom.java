package com.feng.springboot.mapper;

import com.feng.springboot.entity.Vo.CategoryVo;
import com.feng.springboot.entity.Vo.NewItemsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapperCustom {

   List<CategoryVo> getSubCatList(Integer rootCatId);

   /**
    * 查询一级分类下的6条最新商品数据
    */
     List<NewItemsVo> getSixNewItemsLazy(@Param("paramMap") Map<String,Object> map);
}
