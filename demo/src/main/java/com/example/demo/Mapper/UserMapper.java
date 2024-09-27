package com.example.demo.Mapper;

import com.example.demo.common.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询表中用户
     * @param username
     * @return user封装到user实体类中
     */
    @Select("select * from user where username = #{username}")
    User getByUsername(String username);
}
