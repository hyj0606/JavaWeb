package com.pojo;

/**
 * @ClassName User
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-04 12:44
 * @Version 1.0
 */

public class User {
    private long id;
    private String username;
    private String password;

    //当前用户对应的角色.
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
