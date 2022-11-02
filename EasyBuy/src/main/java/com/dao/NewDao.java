package com.dao;

import com.pojo.New;

import java.util.List;

public interface NewDao extends BaseDao {
    List<New> queryAll();
}
