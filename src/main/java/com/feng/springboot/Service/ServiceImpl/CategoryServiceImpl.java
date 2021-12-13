package com.feng.springboot.Service.ServiceImpl;

import com.feng.springboot.Service.CategoryService;
import com.feng.springboot.entity.Category;
import com.feng.springboot.entity.Vo.CategoryVo;
import com.feng.springboot.entity.Vo.NewItemsVo;
import com.feng.springboot.entity.Vo.SimpleItemVo;
import com.feng.springboot.mapper.CategoryMapper;
import com.feng.springboot.mapper.CategoryMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
     private CategoryMapperCustom categoryMapperCustom;
    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("type", 1);
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    @Override
    public List<CategoryVo> getSubCatList(Integer rootCatId) {
       return   categoryMapperCustom.getSubCatList(rootCatId);

    }

    @Override
    public List<NewItemsVo> getSixNewItemsLazy(Integer rootCatId) {
        Map<String, Object> map = new HashMap<>();
        map.put("rootCatId",rootCatId);
        return categoryMapperCustom.getSixNewItemsLazy(map);
    }

}
