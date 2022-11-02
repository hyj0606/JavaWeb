package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-17 15:02
 * @Version 1.0
 */

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public User queryByAccount(String account) {

        //sql语句
        String sql = "select * from easybuy_user where login_name = ?";
        //参数
        Object[] params = {account};

        //调用父类的BaseDao中的query方法
        try {
            resultSet = query(sql,params);
            //账号存在
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String loginName = resultSet.getString("login_name");
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                int sex = resultSet.getInt("sex");
                String identityCode = resultSet.getString("identity_code");
                String email = resultSet.getString("email");
                String mobile = resultSet.getString("mobile");
                int type = resultSet.getInt("type");

                //将数据封装到对象中
                User user = new User(id,loginName,userName,password,sex,identityCode,email,mobile,null,type);

                return user;

            }else {
                //查询失败
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            releaseConn(resultSet,ps,conn);
        }

    }

    //注册账号
    @Override
    public int add(User user) {

        //sql语句
        String sql = "insert into easybuy_user (login_name, user_name, password, sex, identity_code, email, mobile, regtime, type) values (?,?,?,?,?,?,?,?,?)";

        Object[] params = {
                user.getLoginName(),
                user.getUserName(),
                user.getPassword(),
                user.getSex(),
                user.getIdentityCode(),
                user.getEmail(),
                user.getMobile(),
                user.getRegTime(),
                user.getType()
        };

        int result = 0;
        try {
            result = update(sql,params);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;

        }finally {
            releaseConn(resultSet,ps,conn);
        }
    }

    @Override
    public User checkUserName(String userName) {

        //3.编写sql
        String sql = "SELECT * FROM `easybuy_user` WHERE user_name = ?";
        Object[] params = { userName };

        try {
            resultSet = super.query(sql, params);

            //循环遍历解析每一行: 当所有行解析完,则返回false循环结束
            if (resultSet.next()) {
                //解析一行: id,
                int id = resultSet.getInt("id");
                User user = new User();
                user.setId(id);
                return user;
            }else {
                return null;
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;

    }

    @Override
    public int checkLoginName(String loginName) {
        //3.编写sql
        String sql = "SELECT * FROM `easybuy_user` WHERE user_name = ?";
        Object[] params = { loginName };

        try {
            resultSet = super.query(sql, params);

            //循环遍历解析每一行: 当所有行解析完,则返回false循环结束
            if (resultSet.next()) {
                //解析一行: id,

                return 1;
            }else {
                return -1;
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return -1;
    }

    @Override
    public User queryAll( int id ) {

        String sql = " SELECT * FROM `easybuy_user WHERE id = ? ";

        Object[] params = {id};

        try {
            resultSet = query(sql ,params);

            if (resultSet.next()){
                String loginName = resultSet.getString("login_name");
                String userName = resultSet.getString("user_name");
                int sex = resultSet.getInt("sex");
                String identityCode = resultSet.getString("identity_code");
                String email = resultSet.getString("email");
                String mobile = resultSet.getString("mobile");
                String regTime = resultSet.getString("regtime");

                User user = new User(0,loginName,userName,null,sex,identityCode,email,mobile,regTime,0);

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;
    }
}
