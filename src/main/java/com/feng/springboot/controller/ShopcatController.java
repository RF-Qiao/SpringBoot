package com.feng.springboot.controller;
import com.feng.springboot.bo.ShopCartBO;
import com.feng.springboot.util.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/shopcart")
public class ShopcatController {

    @PostMapping("/add")
    public IMOOCJSONResult add(@RequestParam String userId,
                                 @RequestBody ShopCartBO shopCartBO,
                                HttpServletRequest request,
                               HttpServletResponse response
    ) {
        if (StringUtils.isBlank(userId)){
            return IMOOCJSONResult.errorMsg("");
        }
        // TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存
        System.out.println(shopCartBO);
        return IMOOCJSONResult.ok();
    }
}
