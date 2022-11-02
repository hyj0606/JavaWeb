package com.service;

import com.pojo.BuyCar;
import com.pojo.Page;
import com.pojo.Product;

import java.util.List;

public interface ProductService {

    Page queryAllProduct(Integer valueOf , int pNo, int pSize);

    Page querySearchProduct(String productName, int pNo, int pSize);

    int addBuyCar(Integer id);

    List<BuyCar> queryBuyCar();

    Product queryProduct( Integer id );

    List<BuyCar> queryAllBuyCar();

    int cutUpdate(Integer valueOf);

    int plusUpdate(Integer valueOf);

    int delBuyCar(Integer id);

    int queryBuyCarById(Integer id);

    int addBuyCarById(int id);

    int delCar();
}
