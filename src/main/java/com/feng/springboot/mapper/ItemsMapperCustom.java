package com.feng.springboot.mapper;

import com.feng.springboot.entity.Items;
import com.feng.springboot.entity.Vo.ItemCommentVo;
import com.feng.springboot.entity.Vo.SearchItemVO;
import com.feng.springboot.entity.Vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ItemsMapperCustom  {

     List<ItemCommentVo> queryItemComments(@Param("paramsMap") Map<String,Object> map);

     List<SearchItemVO> searchItems(@Param("paramsMap") Map<String,Object> map);

     List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List specId) ;
}
