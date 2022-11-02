package com.dao.impl;

import com.dao.OrderDao;
import com.pojo.BuyCar;
import com.pojo.Detail;
import com.pojo.Order;
import com.pojo.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderDaoImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-18 10:34
 * @Version 1.0
 */

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

    //查询所有商品订单
    @Override
    public List<Order> queryAllOrder(String serialNumber1, int m, int n) {


        //sql
        StringBuffer sql = new StringBuffer("select id, serial_number,create_time,cost from easybuy_order where is_delete = ?  ");

        List list = new ArrayList();

        list.add(0);

        if (serialNumber1 != null){
            sql.append("and serial_number like ?");
            list.add("%"+serialNumber1+"%");
        }

        sql.append(" limit ?,? ");
        list.add(m);
        list.add(n);

        List<Order> orderList = new ArrayList<>();

        try {
            //进行查询
            resultSet = query(sql.toString(),list.toArray());
            while (resultSet.next()){
                //解析数据
                int id = resultSet.getInt("id");
                String serialNumber = resultSet.getString("serial_number");
                String createTime = resultSet.getString("create_time");
                float cost = resultSet.getFloat("cost");

                //将数据封装到对象中
                Order order = new Order(id,createTime, cost, serialNumber);

                //将对象中的数据存储到集合中
                orderList.add(order);

            }
            return orderList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            releaseConn(resultSet,ps,conn);
        }
    }

    //详情商品信息
    @Override
    public List<Detail> queryById(int orderId) {

        /*
         * SELECT od.`user_id`,od.`login_name`,od.`user_address`,od.`serial_number`,od.`cost`,po.`name`,po.`price`
         * FROM `easybuy_order` od , `easybuy_order_detail` oddl , `easybuy_product` po
         * WHERE od.`id`=oddl.`order_id` AND oddl.`product_id`=po.`id` AND od.`id`=1;
         * */
        String sql = "SELECT od.`user_id`,od.`login_name`,od.`user_address`,od.`serial_number`,po.`name`,po.`price` FROM `easybuy_order` od , `easybuy_order_detail` oddl , `easybuy_product` po WHERE od.`id`=oddl.`order_id` AND oddl.`product_id`=po.`id` AND od.`id`= ? ";

        Object[] params = {orderId};

        List list = new ArrayList();

        try {
            resultSet = query(sql,params);

            while (resultSet.next()){
                int userId = resultSet.getInt("user_id");
                String loginName = resultSet.getString("login_name");
                String userAddress = resultSet.getString("user_address");
                String serialNumber = resultSet.getString("serial_number");
                Order order = new Order();
                order.setUserId(userId);
                order.setLoginName(loginName);
                order.setUserAddress(userAddress);
                order.setSerialNumber(serialNumber);


                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                Product product = new Product();
                product.setName(name);
                product.setPrice(price);

                Detail detail = new Detail();
                detail.setOrder(order);
                detail.setProduct(product);

                list.add(detail);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            releaseConn(resultSet,ps,conn);
        }
    }

    @Override
    public int addAddress(Integer id,String run) {

        try {

            //获得user_id
            String sql = " SELECT user_id ,address FROM `easybuy_user_address` WHERE id = ? ";
            Object[] params = {id};
            int userId = 0;
            String address = null;
            resultSet = query(sql,params);
            if (resultSet.next()){
                userId = resultSet.getInt("user_id");
                address = resultSet.getString("address");
            }

            //获得登录名
            String sql1 = " SELECT login_name FROM `easybuy_user` WHERE id = ? ";
            Object[] params1 = { userId };
            String loginName = null;
            query(sql1,params1);
            if (resultSet.next()){
                loginName = resultSet.getString("login_name");
            }

            //创建新订单号
            String sql2 = " INSERT INTO `easybuy_order` (user_id,login_name, user_address,serial_number) VALUE( ?,?,?,? )";
            Object[] params2 = {
                    userId,loginName,address,run
            };
            int result = update(sql2,params2);

            //获得新订单的号的id值
            String sql3 = " SELECT id FROM `easybuy_order` WHERE serial_number= ?";
            Object[] params3 = {run};
            resultSet= query(sql3,params3);
            if (resultSet.next()){
                int orderId = resultSet.getInt("id");
                return orderId;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

    @Override
    public int saveAddress(Integer id, float subtotal, String createTime) {

        String sql  = " UPDATE `easybuy_order` SET create_time=? ,cost=? WHERE id=? ";

        Object[] params = {
                createTime,subtotal,id
        };
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
    public Order queryOrderId(int id) {

        String sql = " SELECT * FROM `easybuy_order` WHERE id = ? ";
        Object[] params = {id};

        try {
            resultSet = query(sql, params);
            if (resultSet.next()){
                int id1 = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String loginName = resultSet.getString("login_name");
                String userAddress = resultSet.getString("user_address");
                float cost = resultSet.getFloat("cost");
                String serialNumber = resultSet.getString("serial_number");

                Order order = new Order(id,userId,loginName,userAddress,null,cost,serialNumber,0);

                return order;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;
    }

    @Override
    public int delBuyCar(int id) {
        try {
            //1.取出BuyCar中的数据
            String sql = " SELECT * FROM `easybuy_buy_car` ";
            Object[] params = {};

            resultSet = query(sql,params);
            List<BuyCar> buyCars = new ArrayList<>();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");//购物车主键id
                int productId = resultSet.getInt("product_id");//商品外键
                int productNum = resultSet.getInt("product_num");//商品数量
                BuyCar buyCar = new BuyCar();
                buyCar.setId(id1);
                buyCar.setProductId(productId);
                buyCar.setProductNum(productNum);
                //2.存储到集合中
                buyCars.add(buyCar);

            }

            //将获取到的数据存储到easybuy_order_detail中

            for (int i = 0; i < buyCars.size(); i++) {

                //获取商品单价
                float price = 0;
                String sql1 = " SELECT price FROM `easybuy_product` WHERE id = ? ";
                Object[] params1 = {
                        buyCars.get(i).getProductId()
                };
                resultSet = query(sql1,params1);
                if (resultSet.next()){

                    price = resultSet.getFloat("price");

                }

                String sql2 = " INSERT INTO `easybuy_order_detail` ( order_id,product_id,quantity,cost ) VALUE ( ?,?,?,? ); ";
                Object[] params2 = {
                        id,
                        buyCars.get(i).getProductId(),
                        buyCars.get(i).getProductNum(),
                        price*buyCars.get(i).getProductNum()
                };
                update(sql2,params2);

            }

            //删除BuyCar中的数据
            String sql3 = " DELETE FROM `easybuy_buy_car` ";
            Object[] params3 = {};
            int result = update(sql3,params3);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        return 0;
    }

    //删除订单
    @Override
    public int del(Integer orderId, Integer isDelete) {
        //sql
        String sql = "UPDATE easybuy_order SET is_delete=?  WHERE id = ? ";
        //参数
        Object[] params = {isDelete,orderId};

        try {
            int result  = update(sql, params);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            releaseConn(resultSet,ps,conn);
        }
    }

    //用于查询总数
    @Override
    public int getCounts(String serialNumber) {
        StringBuffer sql = new StringBuffer("select count(*) from easybuy_order where is_delete=?  ");

        List list = new ArrayList();

        list.add(0);

        if (serialNumber != null){
            sql.append(" and serial_number like ?");
            list.add("%"+serialNumber+"%");
        }

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

}
