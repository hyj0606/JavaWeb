package com.dao.impl;

import com.dao.UserDao;
import com.dao.impl.BaseDao;
import com.pojo.User;


/**
 * @ClassName UserDaoImpl
 * @Description 编写dao层实现: 优化继承BaseDao父类的形式完成数据库操作
 * @Author hyj98
 * @Date 2022-10-04 13:31
 * @Version 1.0
 */

public class UserDaoImpl extends BaseDao implements UserDao {

    public User getUserByName(String username){

        try {
            //编写sql:
            //String sql = "select * from tb_user where username=?";
            String sql = "SELECT u.`id` id,u.`username` username,u.`password` password,r.`role_name` role_name FROM `tb_user` u,`tb_role` r,`tb_user_role` ur WHERE u.`id`=ur.`uid` AND r.`id`=ur.`rid` AND u.`username` = ?";

            //提供参数数值:
            Object[] params = {username};

            //调用操作数据库代码:
            set = super.query(sql, params);

            if (set.next()) {
                long id = set.getLong("id");
                String pwd = set.getString("password");
                String username1 = set.getString("username");
                String roleName = set.getString("role_name");
                User u1 = new User();
                u1.setId(id);
                u1.setUsername(username1);
                u1.setPassword(pwd);
                u1.setRoleName(roleName);
                return u1;

            }else {
                return null;
            }

        }catch (Exception e){
            return null;
        }
    }
}
