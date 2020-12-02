package com.xd.springbootshardingreadwrite.service.Impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.springbootshardingreadwrite.entity.User;
import com.xd.springbootshardingreadwrite.mapper.UserMapper;
import com.xd.springbootshardingreadwrite.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.json.JsonObject;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public List<User> getUserList() {
        return baseMapper.selectList(Wrappers.<User>lambdaQuery());
    }

}
