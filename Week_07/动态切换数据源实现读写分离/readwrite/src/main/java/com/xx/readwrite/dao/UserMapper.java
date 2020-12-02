package com.xx.readwrite.dao;

import com.xx.readwrite.po.User;

import java.util.List;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 16:17
 */
public interface UserMapper {

    Long insert(User user);

    List<User> selectList();
}
