package com.kuang.dao;

import com.kuang.pojo02.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper02 {
    @Select("select * from user")
    List<User> getUsers();
}
