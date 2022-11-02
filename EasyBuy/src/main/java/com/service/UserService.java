package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
    User checkUserName(String userName);

    int checkLoginName(String loginName);

    User queryAll(int id);
}
