package com.dao.impl;

import com.dao.GoodsDao;
import com.dao.impl.BaseDao;
import com.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GoodsDaoImpl
 * @Description 交互数据库: 借助BaseDao实现操作
 * @Author hyj98
 * @Date 2022-10-04 17:52
 * @Version 1.0
 */

public class GoodsDaoImpl extends BaseDao implements GoodsDao {

    //发布商品方法
    public int add(Goods g1){

        //编写sql和参数数组
        String sql = "insert into tb_goods (goods_no,brand,type,price,detail_info,release_time) values (?,?,?,?,?,?)";

        Object[] params = {g1.getGoodsNo(),g1.getBrand(),g1.getType(),g1.getPrice(),g1.getDetailInfo(),g1.getReleaseTime()};

        int r = super.executeUpdate(sql, params);
        return r;

    }

    public int del(long id){

        //编写sql和参数:
        String sql = "delete from tb_goods where id = ?";
        Object[] params = {id};

        int r = super.executeUpdate(sql, params);

        return r;
    }

    public List<Goods> queryAllGoods( String goods_name , int m , int n){
        //3.编写sql
        String sql = "select * from tb_goods where brand like ? limit ?,?";
        Object[] params = { "%"+goods_name+"%" , m , n};

        try {
            set = super.query(sql, params);
            //模拟集合:
            List list = new ArrayList();

            //循环遍历解析每一行: 当所有行解析完,则返回false循环结束
            while (set.next()) {
                //解析一行: id,
                long id = set.getLong("id"); //根据某列名称解析某个单元格数据
                String goodsNo = set.getString("goods_no");
                String brand = set.getString("brand");
                String type = set.getString("type");
                double price = set.getDouble("price");
                String info = set.getString("detail_info");
                String time = set.getString("release_time");

                //2.封装查询结果数据到实体类对象中. 创建集合存储多个实体对象
                //封装以上数据到当前对象中
                Goods g1 = new Goods(id,goodsNo, brand, type, price, info, time);
                //存储对象到集合中
                list.add(g1);

            }
            return list;
        }catch (Exception e){
            return null;
        }finally {
            super.closeResource(set,pstm,conn);
        }
    }

    public Goods queryGoodsById(long id) {
        //3.编写sql
        String sql = "select * from tb_goods where id = ?";
        Object[] params = { id };

        try {
            set = super.query(sql, params);

            //循环遍历解析每一行: 当所有行解析完,则返回false循环结束
            if (set.next()) {
                //解析一行: id,
                long id1 = set.getLong("id"); //根据某列名称解析某个单元格数据
                String goodsNo = set.getString("goods_no");
                String brand = set.getString("brand");
                String type = set.getString("type");
                double price = set.getDouble("price");
                String info = set.getString("detail_info");
                String time = set.getString("release_time");

                //2.封装查询结果数据到实体类对象中. 创建集合存储多个实体对象
                //封装以上数据到当前对象中
                Goods g1 = new Goods(id1,goodsNo, brand, type, price, info, time);
                return g1;
            }

        }catch (Exception e){
            return null;
        }finally {
            super.closeResource(set,pstm,conn);
        }
        return null;
    }

    //修改保存功能
    public int saveGoods(Goods g1){

        //编写sql和参数数组
        String sql = "update tb_goods set brand=?, type=?, price=?, detail_info=?, release_time=? where id = ? ";

        Object[] params = {g1.getBrand(),g1.getType(),g1.getPrice(),g1.getDetailInfo(),g1.getReleaseTime(),g1.getId()};

        int r = super.executeUpdate(sql, params);
        return r;
    }

    @Override
    public int getCounts(String goodsName) {
        String sql = "select count(*) from tb_goods where brand like ?";
        Object[] params = { "%"+goodsName+"%" };

        try {
            set = super.query(sql, params);

            //循环遍历解析每一行: 当所有行解析完,则返回false循环结束
            if (set.next()) {
                //解析一行: id,
                int count = set.getInt(1);

                return count;
            }
        }catch (Exception e){

        }finally {
            super.closeResource(set,pstm,conn);
        }

        return 0;
    }

    @Override
    public int checkGoodsNO(String goodsNo) {
        //3.编写sql
        String sql = "select * from tb_goods where goods_no = ?";
        Object[] params = { goodsNo };

        try {
            set = super.query(sql, params);

            //循环遍历解析每一行: 当所有行解析完,则返回false循环结束
            if (set.next()) {
                //解析一行: id,
                return 1;
            }else {
                return 0;
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            super.closeResource(set,pstm,conn);
        }
        return -1;
    }

}
