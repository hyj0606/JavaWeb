package com.dao;

import com.pojo.Detail;
import com.pojo.Order;

import java.util.List;

public interface OrderDao extends BaseDao {

    int del(Integer orderId, Integer isDelete);

    int getCounts(String serialNumber);

    List<Order> queryAllOrder(String serialNumber ,int m, int n);

    List<Detail> queryById(int orderId);

    int addAddress(Integer id,String run);

    int saveAddress(Integer id, float subtotal, String createTime);

    Order queryOrderId(int id);

    int delBuyCar(int id);
}
