package com.service;

import com.pojo.Detail;
import com.pojo.Order;
import com.pojo.Page;

import java.util.List;

public interface OrderService {

    int del(Integer orderId, Integer isDelete);

    Page queryAll(String serialNumber, int pNo, int pSize);

    List<Detail> queryById(int orderId);

    int addAddress(Integer id,String run);

    int saveOrder(Integer id, float subtotal, String createTime);

    Order queryOrderId(int id);

    int delBuyCar( int id);
}
