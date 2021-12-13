package com.feng.springboot.mapper;

import com.feng.springboot.entity.Items;
import com.feng.springboot.entity.ItemsParam;
import com.feng.springboot.entity.ItemsSpec;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ItemsParamMapper extends Mapper<ItemsParam> {
}
