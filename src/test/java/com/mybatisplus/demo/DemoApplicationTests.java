package com.mybatisplus.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.demo.mapper.UserMapper;
import com.mybatisplus.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }

    //测试插入
    @Test
    void testInsert() {
        User user = new User();

        user.setName("helloWord55");
        user.setAge(5);
        user.setEmail("555555@qq.com");

        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);

    }

    //测试更新
    @Test
    void testupdate() {
        User user = new User();
        //自动拼接sql
        user.setId(6L);

        user.setName("helloWord3333");

        //参数是一个对象
        int insert = userMapper.updateById(user);
        System.out.println(insert);
        System.out.println(user);

    }

    //测试成功案例
    @Test
    public void testupdatelgs() {
        //查询用户信息
        User user = userMapper.selectById(1L);
        //设置用户信息
        user.setEmail("123456.qq.com");
        user.setName("xf");
        //更新用户信息
        userMapper.updateById(user);
    }

    //测试失败案例
    @Test
    public void testupdatelgs2() {
        //查询用户信息
        User user = userMapper.selectById(1L);
        //设置用户信息
        user.setEmail("123456.qq.com");
        user.setName("xf");
        //更新用户信息
        User user2 = userMapper.selectById(1L);
        //设置用户信息
        user.setEmail("1111111.qq.com");
        user.setName("hxf");
        //插队操作
        userMapper.updateById(user2);
        //自旋锁来多次尝试提交
        userMapper.updateById(user);//没有乐观锁就会覆盖之前的值
    }
    @Test//测试按id查询
    public void testID(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
    @Test//测试批量查询
    public void testIDs(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach( System.out::println);
    }
    @Test//测试map条件查询
    public void testmap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","helloWord");
        map.put("age",3);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }
    @Test//测试分页查询
    public void testpage(){
        //参数一：当前页
        //参数二：每页记录数
        //使用分页插件所有分页都变得简单
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取查询记录
       page.getRecords().forEach(System.out::println);
       //获取总记录数
        long total = page.getTotal();
        System.out.println(total);

    }
    @Test//id删除
    public void deleteId(){
        userMapper.deleteById(1L);
    }
    @Test//批量删除
    public void deleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(1265304250628472835L,1265304250628472836L));
    }
    @Test//map删除
    public void deletemap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","helloWord44");
        userMapper.deleteByMap(map);
    }
}
