package com.kuang.dao;

import com.kuang.pojo01.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper01 {
    User getUserById(int id);


    //分页
    List<User> getUserByLimit(Map<String,Integer> map);


    //分页2
    List<User> getUserByRowBounds();





}
