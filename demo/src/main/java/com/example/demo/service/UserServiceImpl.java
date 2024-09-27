package com.example.demo.service;

import com.example.demo.common.MySysUserDetails;
import com.example.demo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(User user){
        //传入用户名和密码
        //UsernamePasswordAuthenticationToken是在Spring Security中用于表示用户名密码身份验证信息的重要类
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());

        //实现登录逻辑，此时就回去调用LoadUserByUsername方法
        Authentication authenticate = authenticationManager.authenticate(usernamePassword);

        //获取返回的用户信息，强转为MySysUserDetails类型
        Object principal = authenticate.getPrincipal();
        MySysUserDetails mySysUserDetails = (MySysUserDetails) principal;

        //输出用户信息
        System.err.println(mySysUserDetails);

        //返回token
        String token= UUID.randomUUID().toString();
        return token;
    }
}
