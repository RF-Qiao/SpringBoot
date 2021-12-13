package com.feng.springboot.controller;
import com.feng.springboot.Service.ItemService;
import com.feng.springboot.common.PagedGridResult;
import com.feng.springboot.entity.Items;
import com.feng.springboot.entity.ItemsImg;
import com.feng.springboot.entity.ItemsParam;
import com.feng.springboot.entity.ItemsSpec;
import com.feng.springboot.entity.Vo.CommentLevelCountVo;
import com.feng.springboot.entity.Vo.ItemInfoVO;
import com.feng.springboot.entity.Vo.ShopcartVO;
import com.feng.springboot.util.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController extends Controller {
    @Autowired
    private ItemService itemService;

    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult subCat(@PathVariable String itemId) {

        Items item = itemService.queryItemById(itemId);
        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecsList = itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemService.queryItemParam(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItems(item);
        itemInfoVO.setItemsImg(itemImgList);
        itemInfoVO.setItemsSpec(itemsSpecsList);
        itemInfoVO.setItemsParam(itemsParam);
        return IMOOCJSONResult.ok(itemInfoVO);
    }

    @GetMapping("/commentLevel")
    public IMOOCJSONResult commentLeevel(@RequestParam String itemId) {
        if (StringUtils.isBlank(itemId)){
            return IMOOCJSONResult.errorMsg("");
        }
        CommentLevelCountVo commentLevelCountVo = itemService.queryCommentCounts(itemId);
        return IMOOCJSONResult.ok(commentLevelCountVo);

    }

    @GetMapping("/comments")
    public IMOOCJSONResult comments(@RequestParam String itemId,
                                    @RequestParam String level,
                                    @RequestParam Integer page,
                                    @RequestParam Integer pageSize
                                    ){
        if (StringUtils.isBlank(itemId)){
            return IMOOCJSONResult.errorMsg(null);
        }

        if(page==null){
            page=1;
        }
        if (pageSize==null){
            pageSize= COMMENT_PAGE_SIZE;
        }
        PagedGridResult grid = itemService.queryPagedComments(     itemId,
                                                                    level,
                                                                    page,
                                                                    pageSize);
        return IMOOCJSONResult.ok(grid);

    }
    @GetMapping("/search")
    public IMOOCJSONResult search( @RequestParam String keywords,
                                    @RequestParam String sort,
                                    @RequestParam Integer page,
                                    @RequestParam Integer pageSize
    ) {
        if (StringUtils.isBlank(keywords)){
            return IMOOCJSONResult.errorMsg(null);
        }

        if(page==null){
            page=1;
        }
        if (pageSize==null){
            pageSize= PAGE_SIZE;
        }

        PagedGridResult grid = itemService.searchItems(keywords,
                                                       sort,
                                                       page,
                                                       pageSize);
        return IMOOCJSONResult.ok(grid);

    }
    @GetMapping("/refresh")
    public IMOOCJSONResult refresh(@RequestParam String itemSpecIds) {
        if (StringUtils.isBlank(itemSpecIds)){
            return IMOOCJSONResult.ok();
        }
        List<ShopcartVO> shopcartVOS = itemService.queryItemsBySpecIds(itemSpecIds);
        return IMOOCJSONResult.ok(shopcartVOS);



    }

}
