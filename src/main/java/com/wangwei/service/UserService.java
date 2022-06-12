package com.wangwei.service;

import com.wangwei.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangwei
 * @date 2022/6/12 10:47
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;  // 由mybatis产生代理对象  与Spring无关 可以单独使用

    public void test() {
        System.out.println(userMapper);
    }
}
