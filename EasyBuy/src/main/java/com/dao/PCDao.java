package com.dao;

import com.pojo.ProductCategory;

import java.util.List;

public interface PCDao extends BaseDao {
    List<ProductCategory> queryAll();

    List<ProductCategory> queryTwoAll( int id);

    List<ProductCategory> queryThreeAll(int id);
}
