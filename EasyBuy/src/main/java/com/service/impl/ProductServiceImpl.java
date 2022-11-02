package com.service.impl;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.pojo.BuyCar;
import com.pojo.Page;
import com.pojo.Product;
import com.service.ProductService;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-21 12:01
 * @Version 1.0
 */

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();

    Page page = new Page();

    @Override
    public Page queryAllProduct(Integer id, int pNo, int pSize){


        //先存储每页大小到page中
        page.setPageSize(pSize);

        //1.按照条件查询---->查询总记录数

        int count = productDao.getCounts( id );
        page.setTotalCount(count);

        //存储当前页码到page中
        page.setPageNo(pNo);

        //2.查询商品,完成分页查询
        List<Product> productList = productDao.queryAllProduct(id,(page.getPageNo()-1)*page.getPageSize(),page.getPageSize());

        //封装查询结果到Page对象中:
        page.setResults(productList);

        //返回page对象
        return page;
    }

    @Override
    public Page querySearchProduct(String productName, int pNo, int pSize) {

        //先存储每页大小到page中
        page.setPageSize(pSize);

        //1.按照条件查询---->查询总记录数

        int count = productDao.getSearchCounts( productName );
        page.setTotalCount(count);

        //存储当前页码到page中
        page.setPageNo(pNo);

        //2.查询商品,完成分页查询
        List<Product> productList = productDao.querySearchProduct(productName,(page.getPageNo()-1)*page.getPageSize(),page.getPageSize());

        //封装查询结果到Page对象中:
        page.setResults(productList);

        //返回page对象
        return page;
    }

    @Override
    public int  addBuyCar(Integer id) {

        int result =  productDao.addBuyCar(id);

        return result;

    }

    @Override
    public List<BuyCar> queryBuyCar() {

        List<BuyCar> buyCarList = productDao.queryBuyCar();

        return buyCarList;

    }

    @Override
    public Product queryProduct(Integer id) {

        Product product = productDao.queryProduct( id );

        return product;

    }

    @Override
    public List<BuyCar> queryAllBuyCar() {

        List<BuyCar> buyCarList = productDao.queryAllBuyCar();

        return buyCarList;

    }

    @Override
    public int cutUpdate(Integer id) {

        int result =  productDao.queryCut(id);

        return result;
    }

    @Override
    public int plusUpdate(Integer id) {
        int result =  productDao.queryPlus(id);

        return result;
    }

    @Override
    public int delBuyCar(Integer id) {

        int result = productDao.delBuyCar(id);

        return result;
    }

    @Override
    public int queryBuyCarById(Integer id) {

        return productDao.queryBuyCarById(id);

    }

    @Override
    public int addBuyCarById(int id) {

        return productDao.addBuyCarById(id);

    }

    @Override
    public int delCar() {

        return productDao.delCar();
    }
}
