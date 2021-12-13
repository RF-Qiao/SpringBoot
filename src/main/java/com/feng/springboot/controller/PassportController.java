package com.feng.springboot.controller;
import com.feng.springboot.Service.UserTestService;
import com.feng.springboot.bo.UserBo;
import com.feng.springboot.entity.Users;
import com.feng.springboot.util.CookieUtils;
import com.feng.springboot.util.IMOOCJSONResult;
import com.feng.springboot.util.JsonUtils;
import com.feng.springboot.util.md5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Api(value = "注册登录",tags = {"用户注册登录的相关接口"})
@RestController
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    public UserTestService userTestService;
    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod ="GET" )
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult UsernameIsExists(@RequestParam String username) {
        //判断用户名不能为空
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //查找是否存在
        boolean isExist = userTestService.queryUsernameIsExist(username);
        if (isExist){
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }
        //请求成功，用户名没有重名
        return IMOOCJSONResult.ok();
    }
    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod ="POST" )
    @PostMapping("/regist")
    public IMOOCJSONResult Regist(@RequestBody UserBo userBo) {
        String username = userBo.getUsername();
        String password = userBo.getPassword();
        String ConfirmPassword = userBo.getConfirmPassword();
        //0.判断用户和密码不为空
        if (StringUtils.isBlank(username)||
                StringUtils.isBlank(password)||
                StringUtils.isBlank(ConfirmPassword)){
            return IMOOCJSONResult.errorMsg("用户名和密码为空~");
        }
        //1.查找是否存在
        boolean isExist = userTestService.queryUsernameIsExist(username);
        if (isExist){
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        //2.判断两次密码是否一致
        if (!password.equals(ConfirmPassword)){
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }
        //3.实现注册
        userTestService.createUser(userBo);
        //请求成功，用户名没有重名
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/login")
    public IMOOCJSONResult Login(@RequestBody UserBo userBo,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        String username = userBo.getUsername();
        String password = userBo.getPassword();
        //0.判断用户和密码不为空
        if (StringUtils.isBlank(username)||
                StringUtils.isBlank(password)){
            return IMOOCJSONResult.errorMsg("用户名和密码为空");
        }
        //3.实现登录
       Users userResult=userTestService.queryUserForLogin(username, md5.MD5(password));
        if (userResult==null){
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }
        userResult = setNull(userResult);
        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(userResult),true);

        //TODO 生成用户token,缓存redis会话
        //TODO 同步购物车数据

        //请求成功，用户名没有重名
        return IMOOCJSONResult.ok(userResult);
    }
        private Users setNull(Users userResult){
            userResult.setPassword(null);
            userResult.setMobile(null);
            userResult.setEmail(null);
            userResult.setCreatedTime(null);
            userResult.setCreatedTime(null);
            return  userResult;
        }
}
