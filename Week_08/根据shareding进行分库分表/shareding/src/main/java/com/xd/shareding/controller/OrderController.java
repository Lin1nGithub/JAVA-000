package com.xd.shareding.controller;

import com.xd.shareding.po.Order;
import com.xd.shareding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/select")
    public List<Order> select() {
        return orderService.getUserList();
    }

    @PostMapping("/insert")
    public Boolean insert(@RequestBody Order order) {
        return orderService.save(order);
    }
}
