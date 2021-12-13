package com.feng.springboot.mapper;


import com.feng.springboot.entity.Users;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserTkMapper extends Mapper<Users> {
}
