package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-19 18:33
 * @Version 1.0
 */

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUserName(String userName) {



        User user = userDao.checkUserName(userName);
        return user;

    }

    @Override
    public int checkLoginName(String loginName) {
        int result = userDao.checkLoginName(loginName);

        return result;
    }

    @Override
    public User queryAll(int id) {
        //调用GoodsDao层
        User user = userDao.queryAll(id);
        return user;
    }
}
