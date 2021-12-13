package com.feng.springboot.mapper;

import com.feng.springboot.entity.Items;
import com.feng.springboot.entity.ItemsImg;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ItemsImgMapper extends Mapper<ItemsImg> {
}
