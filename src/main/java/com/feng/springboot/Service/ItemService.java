package com.feng.springboot.Service;

import com.feng.springboot.common.PagedGridResult;
import com.feng.springboot.entity.Items;
import com.feng.springboot.entity.ItemsImg;
import com.feng.springboot.entity.ItemsParam;
import com.feng.springboot.entity.ItemsSpec;
import com.feng.springboot.entity.Vo.CommentLevelCountVo;
import com.feng.springboot.entity.Vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ItemService {

    /**
     * 根据商品ID查询信息
     * @param itemId
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品Id查询商品图片列表
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 查询商品规格
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数参数
     * @param itemId
     * @return
     */
    ItemsParam queryItemParam(String itemId);

    CommentLevelCountVo queryCommentCounts(String itemId);

    /**
     * 根据商品id查询商品的评价(分页)
     * @param itemId
     * @param level
     * @return
     */
     PagedGridResult queryPagedComments(String itemId,
                                        String level,
                                        Integer page,
                                        Integer pageSize);

    /**
     * 根据关键字搜索商品
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItems       (String keywords,
                                       String sort,
                                       Integer page,
                                       Integer pageSize);

    List<ShopcartVO> queryItemsBySpecIds(String specIds) ;
}
