package com.feng.springboot.mapper;

import com.feng.springboot.entity.Carousel;
import com.feng.springboot.entity.Items;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ItemsMapper extends Mapper<Items> {
}
