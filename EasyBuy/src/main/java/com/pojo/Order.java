package com.pojo;

/**
 * @ClassName Order
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-18 10:25
 * @Version 1.0
 */

public class Order {
    private int id;             //主键
    private int userId;         //用户主键
    private String loginName;   //登录名
    private String userAddress; //用户地址
    private String createTime; //创建时间
    private float cost;         //总消费
    private String serialNumber;//订单号
    private int isDelete;       //删除

    public Order() {
    }

    public Order( int id, String createTime, float cost, String serialNumber) {
        this.id = id;
        this.createTime = createTime;
        this.cost = cost;
        this.serialNumber = serialNumber;
    }

    public Order(int id, int userId, String loginName, String userAddress, String createTime, float cost, String serialNumber, int isDelete) {
        this.id = id;
        this.userId = userId;
        this.loginName = loginName;
        this.userAddress = userAddress;
        this.createTime = createTime;
        this.cost = cost;
        this.serialNumber = serialNumber;
        this.isDelete = isDelete;
    }

    public Order(int id, int userId, String loginName, String userAddress, String createTime, float cost, String serialNumber) {
        this.id = id;
        this.userId = userId;
        this.loginName = loginName;
        this.userAddress = userAddress;
        this.createTime = createTime;
        this.cost = cost;
        this.serialNumber = serialNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
