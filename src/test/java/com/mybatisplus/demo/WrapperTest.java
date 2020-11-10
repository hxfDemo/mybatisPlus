package com.mybatisplus.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatisplus.demo.mapper.UserMapper;
import com.mybatisplus.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testwrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name")
                .isNotNull("age")
                .ge("age",3);
        userMapper.selectList(queryWrapper).forEach(System.out::println);//和刚才的map对比下
    }
    @Test
    public void test2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name","Tom");
        User user = userMapper.selectOne(userQueryWrapper);//查询一个数据，出现多个结果的使用list或map
        System.out.println(user);
    }
    @Test
    public void test3(){
        //1-10岁之间的人
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.between("age",1,5);
        userMapper.selectCount(userQueryWrapper);
    }
    @Test//模糊查询
    public void test4(){
        //1-10岁之间的人
        //左右    t%
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .notLike("name","e")
                .likeRight("email","t");
        userMapper.selectMaps(userQueryWrapper).forEach(System.out::println);
    }
    @Test//子查询
    public void test5(){
        //1-10岁之间的人
        //左右    t%
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .inSql("age","SELECT age FROM user where id>3");
        userMapper.selectObjs(userQueryWrapper).forEach(System.out::println);
    }
    @Test//排序查询
    public void test6(){
        //1-10岁之间的人
        //左右    t%
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .orderByDesc("id");
        userMapper.selectObjs(userQueryWrapper).forEach(System.out::println);
    }
}
