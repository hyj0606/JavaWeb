package com.pojo;

import java.util.List;

/**
 * @ClassName Detail
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-18 17:53
 * @Version 1.0
 */

public class Detail {
    private int id;             //主键
    private Order order;     //订单对象
    private Product product;   //商品对象

    public Detail() {
    }

    public Detail(int id, Order order, Product product) {
        this.id = id;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
