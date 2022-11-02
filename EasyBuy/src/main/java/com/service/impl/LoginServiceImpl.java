package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.LoginService;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-17 14:43
 * @Version 1.0
 */

public class LoginServiceImpl implements LoginService {

    /**
     * 用于检查账号和密码的正确性
     * @param account
     * @param password
     * @return
     */
    @Override
    public User login(String account, String password) {

        //1.检查账号是否正确
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryByAccount(account);

        if (user != null){
            if (password.equals(user.getPassword())){
                return user;
            }else {
                //密码错误
                return null;
            }
        }else {
            //账号未查到
            return null;
        }

    }
}
