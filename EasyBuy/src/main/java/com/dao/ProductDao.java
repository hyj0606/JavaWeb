package com.dao;

import com.pojo.BuyCar;
import com.pojo.Page;
import com.pojo.Product;

import java.util.List;

public interface ProductDao extends BaseDao {
    List<Product> queryAll(int parentId);

    int getCounts( int id );

    List<Product> queryAllProduct(Integer id , int i, int pageSize);

    int getSearchCounts(String productName);

    List<Product> querySearchProduct(String productName, int m, int n);

    int addBuyCar(Integer id);

    List<BuyCar> queryBuyCar();

    Product queryProduct( int id);

    List<BuyCar> queryAllBuyCar();

    int queryCut(Integer id);

    int queryPlus(Integer id);

    int delBuyCar(Integer id);

    int queryBuyCarById(Integer id);

    int addBuyCarById(int id);

    int delCar();
}
