package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao extends BaseDao {
    //检查账号是否存在
    User queryByAccount(String account);

    int add(User user);

    User checkUserName(String userName);

    int checkLoginName(String loginName);

    User queryAll(int id);
}
