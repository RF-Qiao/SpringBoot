package com.feng.springboot.Service;


import com.feng.springboot.bo.UserBo;
import com.feng.springboot.entity.Users;
import org.springframework.stereotype.Repository;


@Repository
public interface UserTestService {
    /**
     * 判断用户名是否存在
     * @param username
     */
    boolean queryUsernameIsExist(String username);

        Users createUser(UserBo userBo);

        //检索用户和密码是否匹配，用于登录
    Users queryUserForLogin(String username,String password);
}
