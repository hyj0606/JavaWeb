package com.service.impl;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.pojo.Detail;
import com.pojo.Order;
import com.pojo.Page;
import com.service.OrderService;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-18 10:32
 * @Version 1.0
 */

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public Page queryAll(String serialNumber,int pNo, int pSize) {
        //创建Page对象
        Page page = new Page();

        //先存储每页大小到page中
        page.setPageSize(pSize);

        //1.按照条件查询---->查询总记录数
        int count = orderDao.getCounts( serialNumber );
        page.setTotalCount(count);

        //存储当前页码到page中
        page.setPageNo(pNo);

        //2.查询商品,完成分页查询
        List<Order> orderList = orderDao.queryAllOrder(serialNumber,(page.getPageNo()-1)*page.getPageSize(),page.getPageSize());

        //封装查询结果到Page对象中:
        page.setResults(orderList);

        //返回page对象
        return page;
    }

    @Override
    public List<Detail> queryById(int orderId) {

        List<Detail> detailList = orderDao.queryById( orderId );

        return detailList;
    }

    @Override
    public int addAddress(Integer id,String run) {

        int number = orderDao.addAddress(id,run);
        return number;

    }

    @Override
    public int saveOrder(Integer id, float subtotal, String createTime) {

        int result = orderDao.saveAddress(id,subtotal,createTime);
        return result;

    }

    @Override
    public Order queryOrderId(int id) {

        Order order = orderDao.queryOrderId(id);

        return order;

    }

    @Override
    public int delBuyCar( int id) {

        return orderDao.delBuyCar(id);

    }

    @Override
    public int del(Integer orderId, Integer isDelete) {

        int result = orderDao.del(orderId,isDelete);

        return result;
    }

}
