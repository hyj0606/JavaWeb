package com.service.impl;

import com.dao.impl.GoodsDaoImpl;
import com.dao.GoodsDao;
import com.pojo.Goods;
import com.pojo.Page;
import com.service.GoodsService;

import java.util.List;


/**
 * @ClassName UserServiceImpl
 * @Description 表示业务逻辑层
 * @Author hyj98
 * @Date 2022-10-04 13:24
 * @Version 1.0
 */

public class GoodsServiceImpl implements GoodsService {

    //调用dao层实例: 优化为全局属性
    GoodsDao goodsDao = new GoodsDaoImpl();
    //新增发布商品:
    public int add(Goods g1){
        int r = goodsDao.add(g1);
        return r;
    }

    //删除指定商品:
    public int del(long id){
        int r = goodsDao.del(id);
        return r;
    }

    //分页查询方法:
    @Override
    public Page queryAllGoods(String goods_name, int pNo, int pSize) {

        //创建Page对象:
        Page page = new Page();

        //先存储每页的大小到page中:
        page.setPageSize(pSize);

        //1.按照查询条件-->查询总记录数
        int count = goodsDao.getCounts( goods_name );
        page.setTotalCount(count);

        //存储当前页码到page中:
        page.setPageNo(pNo);

        //2.查询商品,完成分页查询.
        List<Goods> goods = goodsDao.queryAllGoods(goods_name,(page.getPageNo()-1)*page.getPageSize(),page.getPageSize());

        //封装查询结果到Page对象中:
        page.setList(goods);

        //返回page对象:
        return page;
    }

    //编写单个商品查询功能
    public Goods queryGoodsById(long id){
        Goods g1= goodsDao.queryGoodsById(id);

        return g1;
    }

    //修改存储功能:
    public int saveGoods(Goods g1){
        int r = goodsDao.saveGoods(g1);
        return r;
    }

    @Override
    public int checkGoodsNo(String goodsNo) {
        int r = goodsDao.checkGoodsNO(goodsNo);
        return r;
    }

}
