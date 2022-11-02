package com.dao.impl;

import com.dao.PCDao;
import com.pojo.ProductCategory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PCDaoImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-21 9:06
 * @Version 1.0
 */

public class PCDaoImpl extends BaseDaoImpl implements PCDao {
    @Override
    public List<ProductCategory> queryAll() {

        String sql = " SELECT * FROM `easybuy_product_category` WHERE TYPE=1 ";

        Object[] params = {};

        try {
            resultSet = query(sql,params);

            List<ProductCategory> list = new ArrayList<>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int type = resultSet.getInt("type");

                ProductCategory pc = new ProductCategory(id,name,0,type,null);

                list.add(pc);

            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;
    }

    @Override
    public List<ProductCategory> queryTwoAll(int id) {

        String sql = " SELECT * FROM `easybuy_product_category` WHERE parent_id = ? ";
        Object[] params = {id};

        try {
            resultSet = query(sql,params);
            List<ProductCategory> list = new ArrayList<>();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int type = resultSet.getInt("type");
                ProductCategory pc = new ProductCategory(id1,name,0,type,null);
                list.add(pc);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;
    }

    @Override
    public List<ProductCategory> queryThreeAll(int id) {

        String sql = " SELECT * FROM `easybuy_product_category` WHERE parent_id = ? ";
        Object[] params = {id};

        try {
            resultSet = query(sql,params);
            List<ProductCategory> list = new ArrayList<>();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int type = resultSet.getInt("type");
                ProductCategory pc = new ProductCategory(id1,name,0,type,null);
                list.add(pc);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;

    }
}
