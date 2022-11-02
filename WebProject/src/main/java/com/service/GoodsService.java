package com.service;

import com.pojo.Goods;
import com.pojo.Page;

import java.util.List;

public interface GoodsService {
    //新增发布商品:
    public int add(Goods g1);

    //删除指定商品:
    public int del(long id);

    //编写查询功能
    public Page queryAllGoods(String goods_name, int pNo, int pSize);

    //编写单个商品查询功能
    public Goods queryGoodsById(long id);

    //修改存储功能:
    public int saveGoods(Goods g1);

    int checkGoodsNo(String goodsNo);
}
