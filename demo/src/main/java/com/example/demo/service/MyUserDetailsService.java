package com.example.demo.service;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.common.MySysUserDetails;
import com.example.demo.common.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    /**
     * UserDetailsService：SpringSecurity的接口，提供查询用户功能，如根据用户名查询用户，并返回UserDetails
     * UserDetails：SpringSecurity定义的类， 记录用户信息，如用户名、密码、权限等。
     */

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1、根据用户名从数据库中查询用户
        User user = userMapper.getByUsername(username);
        //2、处理各种异常情况：用户名不存在、密码不对
        if (user == null) {
            //用户不存在
            throw new UsernameNotFoundException("用户不存在");
        }
        //3、转换成MySysUserDetails对象
        return new MySysUserDetails(user);
    }

}
