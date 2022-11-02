package com.service.impl;

import com.dao.PCDao;
import com.dao.impl.PCDaoImpl;
import com.pojo.ProductCategory;
import com.service.ProductCategoryService;

import java.util.List;

/**
 * @ClassName ProductCategoryServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-21 9:03
 * @Version 1.0
 */

public class ProductCategoryServiceImpl implements ProductCategoryService {
    PCDao pcDao = new PCDaoImpl();

    @Override
    public List<ProductCategory> queryAll() {


        List<ProductCategory> pCList = pcDao.queryAll();

        return pCList;

    }

    @Override
    public List<ProductCategory> queryTwoAll(int id) {

        List<ProductCategory> pcTwoList = pcDao.queryTwoAll(id);

        return pcTwoList;

    }

    @Override
    public List<ProductCategory> queryThreeAll(int id) {
        List<ProductCategory> pcThreeList = pcDao.queryThreeAll(id);

        return pcThreeList;
    }

}
