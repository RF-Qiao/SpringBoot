package com.feng.springboot.Service.ServiceImpl;
import com.feng.springboot.Service.ItemService;
import com.feng.springboot.common.CommentLevel;
import com.feng.springboot.common.PagedGridResult;
import com.feng.springboot.entity.*;
import com.feng.springboot.entity.Vo.CommentLevelCountVo;
import com.feng.springboot.entity.Vo.ItemCommentVo;
import com.feng.springboot.entity.Vo.SearchItemVO;
import com.feng.springboot.entity.Vo.ShopcartVO;
import com.feng.springboot.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
  @Service
public class ItemServiceImpl implements ItemService {
      @Autowired
      private ItemsMapper itemsMapper;
      @Autowired
      private ItemsImgMapper itemsImgMapper;
      @Autowired
      private ItemSpecMapper itemSpecMapper;
      @Autowired
      private ItemsParamMapper itemsParamMapper;
      @Autowired
      private ItemsCommentsMapper itemsCommentsMapper;
      @Autowired
      private  ItemsMapperCustom itemsMapperCustom;

    @Override
    public Items queryItemById(String itemId) {
       return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public List<ItemsImg> queryItemImgList(String itemId){
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("itemId",itemId);
         return  itemsImgMapper.selectByExample(example);
    }

    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("itemId",itemId);
        return  itemSpecMapper.selectByExample(example);
    }

    @Override
    public ItemsParam queryItemParam(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("itemId",itemId);
        return  itemsParamMapper.selectOneByExample(example);
    }

      @Override
      public CommentLevelCountVo queryCommentCounts(String itemId) {
        Integer goodCounts= getCommentCounts(itemId, CommentLevel.GOOD.Type);
        Integer normalCounts= getCommentCounts(itemId, CommentLevel.NorMal.Type);
        Integer badCounts= getCommentCounts(itemId, CommentLevel.BAD.Type);
        Integer totalCounts=goodCounts+normalCounts+badCounts;

          CommentLevelCountVo commentLevelCountVo = new CommentLevelCountVo();
          commentLevelCountVo.setGoodCounts(goodCounts);
          commentLevelCountVo.setNormalCounts(normalCounts);
          commentLevelCountVo.setBadCounts(badCounts);
          commentLevelCountVo.setTotalCounts(totalCounts);
          return commentLevelCountVo;
      }


      Integer getCommentCounts(String itemId,Integer level){
          ItemsComments itemsComments = new ItemsComments();
          itemsComments.setItemId(itemId);
          if (level!=null){
            itemsComments.setCommentLevel(level);
          }
          return  itemsCommentsMapper.selectCount(itemsComments);
      }

      @Override
      public PagedGridResult queryPagedComments(String itemId,
                                                String level,
                                                Integer page,
                                                Integer pageSize) {
          HashMap<String, Object> map = new HashMap<>();
          map.put("itemId",itemId);
          map.put("level",level);
          List<ItemCommentVo> list = itemsMapperCustom.queryItemComments(map);
          PageHelper.startPage(page,pageSize);

          return setterPagedGrid(list,page);
      }


      @Override
      public PagedGridResult searchItems(String keywords,
                                         String sort,
                                         Integer page,
                                         Integer pageSize){
          HashMap<String, Object> map = new HashMap<>();
          map.put("keywords",keywords);
          map.put("sort",sort);
          List<SearchItemVO> list = itemsMapperCustom.searchItems(map);
          PageHelper.startPage(page,pageSize);
          return setterPagedGrid(list,page);

      }

      @Override
      public List<ShopcartVO> queryItemsBySpecIds(String specIds) {
            String ids[]= specIds.split(",");
          List<String> specIdList = new ArrayList<>();
             Collections.addAll(specIdList,ids);
           return itemsMapperCustom.queryItemsBySpecIds(specIdList);
      }

      private PagedGridResult setterPagedGrid(List<?> list,
                                                Integer page){
            PageInfo<?> pageList= new PageInfo<>();
            PagedGridResult grid = new PagedGridResult();
            grid.setPage(page);
            grid.setRows(list);
            grid.setTotal(2);
            //grid.setTotal(list.size());
            //总记录数
             grid.setRecords(list.size());
            //grid.setRecords(pageList.getTotal());
            return grid;
        }
  }
