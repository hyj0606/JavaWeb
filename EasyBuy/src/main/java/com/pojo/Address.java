package com.pojo;

/**
 * @ClassName Address
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-18 22:27
 * @Version 1.0
 */

public class Address {
    private int id;             //主键id
    private String address;     //地址
    private String tel;
    private int isDefault;      //是否是默认地址(1:是, 0:否)

    private String remark;      //备注
    private User user;

    public Address() {
    }

    public Address(int id, String address, String tel, int isDefault, String remark, User user) {
        this.id = id;
        this.address = address;
        this.tel = tel;
        this.isDefault = isDefault;
        this.remark = remark;
        this.user = user;
    }

    public Address(int id, String address, int isDefault, User user, String remark) {
        this.id = id;
        this.address = address;
        this.isDefault = isDefault;
        this.user = user;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
