package com.pojo;

/**
 * @ClassName User
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-17 14:43
 * @Version 1.0
 */

public class User {
    private int id;             //主键
    private String loginName;   //登录名
    private String userName;    //用户名
    private String password;    //密码
    private int sex;            //性别(1:男  0:女)
    private String identityCode;//身份证号
    private String email;       //邮箱
    private String mobile;      //手机
    private String regTime;     //注册时间
    private int type;           //类型(1:后天  0:前台)

    public User() {
    }

    public User(int id, String loginName, String userName, String password, int sex, String identityCode, String email, String mobile, String regTime, int type) {
        this.id = id;
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.identityCode = identityCode;
        this.email = email;
        this.mobile = mobile;
        this.regTime = regTime;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
