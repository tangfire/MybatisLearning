package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //根据ID查询用户
    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    //万能的Map
    int addUserMap(Map<String,Object> map);

    // 模糊查询
    List<User> findUsersByName(String name);




}