package com.pojo;

/**
 * @ClassName BuyCar
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-24 20:39
 * @Version 1.0
 */

public class BuyCar {
    private int id;                 //主键
    private int productId;          //商品外键
    private int productNum;         //商品数量
    private float productSubtotal;  //总价
    private float totalPrice;       //小计
    private int isDel;              //是否删除
    private int num;                //总数
    private Product product;        //product对象

    public BuyCar() {
    }

    public BuyCar(int id, int productId, int productNum, float productSubtotal, float totalPrice, int isDel) {
        this.id = id;
        this.productId = productId;
        this.productNum = productNum;
        this.productSubtotal = productSubtotal;
        this.totalPrice = totalPrice;
        this.isDel = isDel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public float getProductSubtotal() {
        return productSubtotal;
    }

    public void setProductSubtotal(float productSubtotal) {
        this.productSubtotal = productSubtotal;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
