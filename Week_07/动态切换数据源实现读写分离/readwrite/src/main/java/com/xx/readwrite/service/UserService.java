package com.xx.readwrite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xx.readwrite.po.User;

import java.util.List;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 15:29
 */
public interface UserService {

    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    Long save(User entity);

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> getUserList();
}
