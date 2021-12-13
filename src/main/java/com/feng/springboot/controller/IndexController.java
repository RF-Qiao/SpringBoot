package com.feng.springboot.controller;
import com.feng.springboot.Service.CarouselService;
import com.feng.springboot.Service.CategoryService;
import com.feng.springboot.common.YesOrNo;
import com.feng.springboot.entity.Carousel;
import com.feng.springboot.entity.Category;
import com.feng.springboot.entity.Vo.CategoryVo;
import com.feng.springboot.entity.Vo.NewItemsVo;
import com.feng.springboot.util.IMOOCJSONResult;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(value = "首页",tags = {"首页展示相关接口"})
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表",notes = "获取首页轮播图列表",httpMethod ="GET" )
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel(){
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.Type);
        return IMOOCJSONResult.ok(carousels);
    }
    /**
     * 首页分类展示需求：
     * 1.第一次刷新主页查询大分累，渲染展示到首页
     * 2.如果鼠标上移到大根类，则加载其子分类的内容，如果已经存在子分类，则不需要加载(懒加载)
     */
    @GetMapping("/cats")
    public IMOOCJSONResult cats(){
        List<Category> category = categoryService.queryAllRootLevelCat();

        return IMOOCJSONResult.ok(category);
    }

    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(@PathVariable Integer rootCatId){
        List<CategoryVo> list = categoryService.getSubCatList(rootCatId);
        return IMOOCJSONResult.ok(list);
    }
    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据",notes = "查询每个一级分类下的最新6条商品数据",httpMethod ="GET" )
    @GetMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult sixNewItems(@ApiParam(name = "rootCatId",value = "一级分类id",required = true)
            @PathVariable Integer rootCatId){
        if (rootCatId==null){
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<NewItemsVo> list = categoryService.getSixNewItemsLazy(rootCatId);
        return IMOOCJSONResult.ok(list);
    }
}
