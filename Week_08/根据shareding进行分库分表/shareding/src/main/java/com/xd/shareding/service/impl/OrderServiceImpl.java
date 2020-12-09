package com.xd.shareding.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.shareding.mapper.OrderMapper;
import com.xd.shareding.po.Order;
import com.xd.shareding.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService  {

    @Override
    public boolean save(Order entity) {
        return super.save(entity);
    }

    @Override
    public List<Order> getUserList() {
        return baseMapper.selectList(Wrappers.<Order>lambdaQuery());
    }
}
