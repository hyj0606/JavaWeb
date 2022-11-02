package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.RegistService;

/**
 * @ClassName RegistServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-17 16:42
 * @Version 1.0
 */

public class RegistServiceImpl implements RegistService {
    @Override
    public int add(User user) {

        UserDao userDao = new UserDaoImpl();
        int result = userDao.add(user);

        return result;
    }
}
