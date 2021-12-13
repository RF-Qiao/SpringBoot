package com.feng.springboot.mapper;

import com.feng.springboot.entity.ItemsImg;
import com.feng.springboot.entity.ItemsSpec;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ItemSpecMapper extends Mapper<ItemsSpec> {
}
