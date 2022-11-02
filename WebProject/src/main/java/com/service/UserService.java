package com.service;

import com.pojo.User;

public interface UserService {

    //登录处理功能
    public User login(String username, String password);
}
