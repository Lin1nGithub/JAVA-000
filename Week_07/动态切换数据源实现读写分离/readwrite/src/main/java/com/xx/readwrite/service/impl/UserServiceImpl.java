package com.xx.readwrite.service.impl;

import com.xx.readwrite.config.DataSourceRoutingKey;
import com.xx.readwrite.config.annotation.DataSourceRouting;
import com.xx.readwrite.dao.UserMapper;
import com.xx.readwrite.po.User;
import com.xx.readwrite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 15:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DataSourceRouting(value = DataSourceRoutingKey.WRITE)
    public Long save(User entity) {
        return userMapper.insert(entity);
    }

    @Override
    @DataSourceRouting(value = DataSourceRoutingKey.READ)
    public List<User> getUserList() {
        return userMapper.selectList();
    }
}
