package com.xd.shareding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.shareding.po.Order;

import java.util.List;

public interface OrderService extends IService<Order> {

    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    @Override
    boolean save(Order entity);

    /**
     * 查询全部用户信息
     * @return
     */
    List<Order> getUserList();
}
