package com.feng.springboot.Service.ServiceImpl;

import com.feng.springboot.Service.UserTestService;
import com.feng.springboot.bo.UserBo;
import com.feng.springboot.common.Sex;
import com.feng.springboot.entity.Users;
import com.feng.springboot.mapper.UserTkMapper;
import com.feng.springboot.util.DateUtil;
import com.feng.springboot.util.idworker.Sid;
import com.feng.springboot.util.md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.Random;

@Service
public class UserTestServiceImpl implements UserTestService {
    @Autowired
    public UserTkMapper userTkMapper;
    @Autowired
    private Sid sid;
    private final static String USER_FACE="https://cn.bing.com/images/search?view=detailV2&ccid=FaG6dzoh&id=E4CFCEE0D7CAE7BDCFCD4EEF7C4845CB3A245C87&thid=OIP.FaG6dzohGs3q45-DwsEyQQHaEK&mediaurl=https%3a%2f%2ftse1-mm.cn.bing.net%2fth%2fid%2fR-C.15a1ba773a211acdeae39f83c2c13241%3frik%3dh1wkOstFSHzvTg%26riu%3dhttp%253a%252f%252fwww.desktx.com%252fd%252ffile%252fwallpaper%252fscenery%252f20170120%252ffdf948c82074494a74bf258eed4f855d.jpg%26ehk%3dfYrgVtm0hD0sZn455mcVyf5k%252bQz7RScjHLMyUi6jG0A%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=945&expw=1680&q=%e5%9b%be%e7%89%87&simid=608028886649558706&FORM=IRPRST&ck=D470F24E5A731FA4B7F4E96539D01A75&selectedIndex=2&ajaxhist=0&ajaxserp=0";
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("username",username);
        Users user= userTkMapper.selectOneByExample(example);
        return user==null? false:true;
    }

    @Override
    public Users createUser(UserBo userBo) {
        Integer userId =sid.insertid() ;
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBo.getUsername());
        user.setPassword(md5.MD5(userBo.getPassword()));
        user.setNickname(userBo.getUsername());
        //默认头像
        user.setFace(USER_FACE);
        //设置默认生日
        user.setBirthday(DateUtil.stringToDate("1990-01-01"));
        //默认性别保密
        user.setSex(Sex.Secret.Type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        userTkMapper.insert(user);
        return  user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("username",username)
                .andEqualTo("password",password);
        Users user= userTkMapper.selectOneByExample(example);
        return user;
    }

}
