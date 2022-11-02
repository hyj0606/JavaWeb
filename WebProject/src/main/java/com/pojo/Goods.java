package com.pojo;

/**
 * @ClassName Goods
 * @Description 实体类： 模型
 * @Author hyj98
 * @Date 2022-10-03 15:43
 * @Version 1.0
 */

public class Goods {

    private long id;
    private String goodsNo;
    private String brand;
    private String type;
    private double price;
    private String detailInfo;
    private String releaseTime;

    public Goods() {
    }

    public Goods(long id, String goodsNo, String brand, String type, double price, String detailInfo, String releaseTime) {
        this.id = id;
        this.goodsNo = goodsNo;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.detailInfo = detailInfo;
        this.releaseTime = releaseTime;
    }

    public Goods(long id, String brand, String type, double price, String detailInfo, String releaseTime) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.detailInfo = detailInfo;
        this.releaseTime = releaseTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}
