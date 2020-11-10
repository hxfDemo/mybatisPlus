package com.mybatisplus.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component//一定放到ioc容器
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
log.info("start insertFill");
this.setFieldValByName("createTime",new Date(),metaObject );
this.setFieldValByName("updateTime",new Date(),metaObject );
    }
    //更新填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start updateFill");
        this.setFieldValByName("updateTime",new Date(),metaObject );
    }
}
