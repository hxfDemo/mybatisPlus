package com.mybatisplus.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.demo.pojo.User;
import org.springframework.stereotype.Repository;

@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
    //CRUD基本操作已完成
}
