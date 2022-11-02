package com.pojo;

/**
 * @ClassName Product
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-18 17:53
 * @Version 1.0
 */

public class Product {
    private int id;         //主键
    private String name;    //名称
    private float price;    //单价
    private int levelOne; //分类一
    private int levelTwo; //分类二
    private int levelThree; //分类三

    public Product() {
    }

    public Product(int id, String name, float price, int levelOne, int levelTwo, int levelThree) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
        this.levelThree = levelThree;
    }

    public Product(int id, String name, float price, int levelThree) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.levelThree = levelThree;
    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(int levelThree) {
        this.levelThree = levelThree;
    }

    public int getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(int levelOne) {
        this.levelOne = levelOne;
    }

    public int getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(int levelTwo) {
        this.levelTwo = levelTwo;
    }
}
