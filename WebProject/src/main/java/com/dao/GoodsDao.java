package com.dao;

import com.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

public interface GoodsDao {

    //发布商品方法
    public int add(Goods g1);

    public int del(long id);

    public List<Goods> queryAllGoods( String goods_name , int m , int n );

    public Goods queryGoodsById(long id) ;

    //修改保存功能
    public int saveGoods(Goods g1);

    //查询总数
    public int getCounts(String goodsName);


    int checkGoodsNO(String goodsNo);
}
