package com.service.impl;

import com.dao.impl.UserDaoImpl;
import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description 表示业务逻辑层
 * @Author hyj98
 * @Date 2022-10-04 13:24
 * @Version 1.0
 */

public class UserServiceImpl implements UserService {

    //全局属性: 提供为接口类型引用
    UserDao userDao = new UserDaoImpl();

    //登录处理功能
    public User login(String username,String password){

        //1.调用dao层: 查询账号是否存在

        User u1 = userDao.getUserByName(username);

        //2.检查密码是否正确
        if (u1 != null){
            //账号存在:
            if (u1.getPassword().equals(password)){
                //密码正确
                return u1;
            }else {
                //密码错误:
                return null;
            }

        }else {
            //账号不存在:
            return null;
        }

        //3.返回结果

    }
}
