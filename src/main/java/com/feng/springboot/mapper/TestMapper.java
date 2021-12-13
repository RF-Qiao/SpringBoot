package com.feng.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.springboot.entity.Items;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper extends BaseMapper<Items> {
}
