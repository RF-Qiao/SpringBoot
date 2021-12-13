package com.feng.springboot.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户对象BO",description = "从客户端由用户传入的数据封装再次entity中")
public class UserBo {
    @ApiModelProperty(value = "用户名",name = "username",example = "immoc",required = true)
    private String username;
    @ApiModelProperty(value = "密码",name = "password",example = "123456",required =true)
    private String password;
    @ApiModelProperty(value = "确认密码",name = "confirmPassword",example = "123456",required =false)
    private String confirmPassword;

}
