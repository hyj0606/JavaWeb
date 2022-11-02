package com.dao.impl;

import com.dao.ProductDao;
import com.pojo.BuyCar;
import com.pojo.Order;
import com.pojo.Page;
import com.pojo.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductDaoImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-21 13:48
 * @Version 1.0
 */

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {
    @Override
    public List<Product> queryAll(int parentId) {

        String sql = "SELECT * FROM `easybuy_product` WHERE categoryLevel3Id = ? ";

        Object[] params = {parentId};

        try {
            resultSet = query(sql,params);

            List<Product> productList = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int levelThree = resultSet.getInt("categoryLevel3Id");

                Product product = new Product(id,name,price,levelThree);

                productList.add(product);
            }

            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;
    }

    @Override
    public int getCounts( int id ) {

        StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM `easybuy_product` WHERE  categoryLevel1Id = ? OR categoryLevel2Id = ? OR categoryLevel3Id = ?  ");

        List list = new ArrayList();

        /*if (productName != null){
            sql.append(" and name like ?");
            list.add("%"+productName+"%");
        }*/

        list.add(id);
        list.add(id);
        list.add(id);

        try {
            resultSet = query(sql.toString(),list.toArray());

            if (resultSet.next()){
                //解析一行: id
                int count = resultSet.getInt(1);
                return count;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;


    }


    @Override
    public List<Product> queryAllProduct(Integer id, int i, int pageSize) {

        //sql
        StringBuffer sql = new StringBuffer(" SELECT * FROM `easybuy_product` WHERE categoryLevel1Id = ? OR categoryLevel2Id = ? OR categoryLevel3Id = ? ");

        List list = new ArrayList();

        list.add( id );
        list.add( id );
        list.add( id );

        /*if (productName != null){
            sql.append(" name ");
            list.add(productName);
        }*/

        sql.append(" limit ?,? ");
        list.add(i);
        list.add(pageSize);

        List<Product> productList = new ArrayList<>();

        try {
            //进行查询
            resultSet = query(sql.toString(),list.toArray());
            while (resultSet.next()){

                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int levelThree = resultSet.getInt("categoryLevel3Id");

                Product product = new Product(id1,name,price,levelThree);

                productList.add(product);

            }
            return productList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            releaseConn(resultSet,ps,conn);
        }

    }

    @Override
    public int getSearchCounts(String productName) {
        StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM `easybuy_product` WHERE 1=1 AND name like ?  ");

        List list = new ArrayList();

        /*if (productName != null){
            sql.append(" and name like ?");
            list.add("%"+productName+"%");
        }*/

        list.add("%"+productName+"%");

        try {
            resultSet = query(sql.toString(),list.toArray());

            if (resultSet.next()){
                //解析一行: id
                int count = resultSet.getInt(1);
                return count;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

    @Override
    public List<Product> querySearchProduct(String productName, int m, int n) {

        //sql
        StringBuffer sql = new StringBuffer(" SELECT * FROM `easybuy_product` WHERE name like ? ");

        List list = new ArrayList();

        list.add( "%"+productName+"%" );

        /*if (productName != null){
            sql.append(" name ");
            list.add(productName);
        }*/

        sql.append(" limit ?,? ");
        list.add(m);
        list.add(n);

        List<Product> productList = new ArrayList<>();

        try {
            //进行查询
            resultSet = query(sql.toString(),list.toArray());
            while (resultSet.next()){

                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int levelThree = resultSet.getInt("categoryLevel3Id");

                Product product = new Product(id1,name,price,levelThree);

                productList.add(product);

            }
            return productList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            releaseConn(resultSet,ps,conn);
        }

    }

    @Override
    public int addBuyCar(Integer id) {

        String sql = " SELECT * FROM `easybuy_product` WHERE id = ? ";

        Object[] params = { id };

        int id1=0;
        String name=null;
        float price=0;
        int level3Id=0;


        try {
            resultSet = query(sql, params);
            List<Product> productList = new ArrayList<>();

            if (resultSet.next()){

                id1 = resultSet.getInt("id");
                name = resultSet.getString("name");
                price = resultSet.getFloat("price");
                level3Id = resultSet.getInt("categoryLevel3Id");
                Product product = new Product(id1, name, price, level3Id );

                productList.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        String sql2  = " INSERT INTO `easybuy_buy_car` SET product_id = ? ";

        Object[] params2 = {
                id1,
        };

        try {
            int result = update(sql2,params2);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

    @Override
    public List<BuyCar> queryBuyCar() {

        String sql = "SELECT pr.`name`,bc.`product_id`,bc.`product_num`, pr.`price` FROM `easybuy_buy_car` bc, `easybuy_product` pr WHERE bc.`product_id` = pr.`id`;";
        Object[] params = {};

        try {
            resultSet = query(sql,params);
            List<BuyCar> buyCarList = new ArrayList<>();

            while (resultSet.next()){

                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                int productNum = resultSet.getInt("product_num");
                float price = resultSet.getFloat("price");

                Product product = new Product();
                product.setPrice(price);
                product.setName(name);

                BuyCar buyCar = new BuyCar();
                buyCar.setProduct(product);
                buyCar.setProductId(productId);
                buyCar.setProductNum(productNum);

                buyCarList.add(buyCar);
            }

            return buyCarList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        return null;
    }

    @Override
    public Product queryProduct( int id ) {

        String sql = " SELECT * FROM `easybuy_product` WHERE id = ? ";
        Object[] params = {
                id
        };

        try {
            resultSet = query(sql,params);
            if (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");

                Product product = new Product();
                product.setId(id1);
                product.setName(name);
                product.setPrice(price);

                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        return null;

    }

    @Override
    public List<BuyCar> queryAllBuyCar() {

        String sql = "SELECT bc.`id`,  pr.`name`,bc.`product_id`,bc.`product_num`, pr.`price` FROM `easybuy_buy_car` bc, `easybuy_product` pr WHERE bc.`product_id` = pr.`id`;";
        Object[] params = {};

        try {
            resultSet = query(sql,params);
            List<BuyCar> buyCarList = new ArrayList<>();

            while (resultSet.next()){

                int id = resultSet.getInt("id");
                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                int productNum = resultSet.getInt("product_num"); //数量
                float price = resultSet.getFloat("price");

                Product product = new Product();
                product.setPrice(price);
                product.setName(name);

                BuyCar buyCar = new BuyCar();
                buyCar.setId(id);
                buyCar.setProduct(product);
                buyCar.setProductId(productId);
                buyCar.setProductNum(productNum);

                buyCarList.add(buyCar);
            }

            return buyCarList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        return null;

    }

    @Override
    public int queryCut(Integer id) {

        String sql = " UPDATE `easybuy_buy_car` SET product_num = product_num-1 WHERE id=? ";

        Object[] params = {id};

        try {
            int result = update(sql,params);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

    @Override
    public int queryPlus(Integer id) {
        String sql = " UPDATE `easybuy_buy_car` SET product_num = product_num+1 WHERE id=? ";

        Object[] params = {id};

        try {
            int result = update(sql,params);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

    @Override
    public int delBuyCar(Integer id) {

        String sql = " DELETE FROM `easybuy_buy_car` WHERE id = ? ";

        Object[] params = {id};

        try {
            int result = update(sql,params);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        return 0;
    }

    @Override
    public int queryBuyCarById(Integer id) {

        String sql = " SELECT id  FROM `easybuy_buy_car` WHERE product_id = ? ";
        Object[] params = {id};
        try {
            resultSet = query(sql,params);
            if (resultSet.next()){
                int id1 = resultSet.getInt("id");
                return id1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

    @Override
    public int addBuyCarById(int id) {
        try {
            String sql = " UPDATE  `easybuy_buy_car` SET product_num = product_num+1 WHERE id = ? ";
            Object[] params = {id};
            int result = update(sql,params);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

    @Override
    public int delCar() {

        String sql = " DELETE FROM `easybuy_buy_car`";

        Object[] params = {};

        try {
            int result = update(sql,params);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        return 0;

    }
}
