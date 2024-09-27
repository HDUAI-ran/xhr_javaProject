package com.example.demo.controller;

import com.example.demo.common.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 测试
     * @return
     */
    @GetMapping()
    public String test(){
        return "Hello World!";
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @GetMapping("/login")
    public String login(User user){
        String token = userService.login(user);
        return token;
    }
}
