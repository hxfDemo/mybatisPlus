package com.mybatisplus.demo.blog.service.impl;

import com.mybatisplus.demo.blog.pojo.User;
import com.mybatisplus.demo.blog.mapper.UserMapper;
import com.mybatisplus.demo.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexiaofei
 * @since 2020-05-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
