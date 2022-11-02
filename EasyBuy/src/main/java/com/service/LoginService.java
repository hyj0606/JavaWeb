package com.service;

import com.pojo.User;

public interface LoginService {

    /*查询账号和密码是否有误*/
    User login(String account, String password);
}
