package com.xx.readwrite.api;

import com.xx.readwrite.po.User;
import com.xx.readwrite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 15:30
 */
@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public List<User> select() {
        return userService.getUserList();
    }

    @PostMapping("/insert")
    public Long insert(@RequestBody User user) {
        return userService.save(user);
    }
}
