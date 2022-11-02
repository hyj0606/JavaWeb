package com.service;

import com.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> queryAll();

    List<ProductCategory> queryTwoAll(int id);

    List<ProductCategory> queryThreeAll(int id);
}
