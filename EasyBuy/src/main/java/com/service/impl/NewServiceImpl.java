package com.service.impl;

import com.dao.NewDao;
import com.dao.impl.NewDaoImpl;
import com.pojo.New;
import com.service.NewService;

import java.util.List;

/**
 * @ClassName NewServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-20 14:58
 * @Version 1.0
 */

public class NewServiceImpl implements NewService {
    @Override
    public List<New> queryAll() {

        NewDao newDao = new NewDaoImpl();

        List<New> newList = newDao.queryAll();

        return newList;

    }
}
