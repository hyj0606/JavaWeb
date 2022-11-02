package com.dao.impl;

import com.dao.BaseDao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName BaseDaoImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-11 10:14
 * @Version 1.0
 */

public class BaseDaoImpl implements BaseDao {

    //抽取公共信息:
    private static String url;
    private static String driver;
    private static String user;
    private static String password;

    //声明为静态共享对象
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet resultSet;

    //1.使用静态代码块,安装驱动
    static {
        //1.1 加载外部配置信息
        //类加载器: 使用反射
        InputStream is = BaseDaoImpl.class.getClassLoader().getResourceAsStream("jdbc.properties");

        //创建空集合(key-value)
        Properties properties = new Properties();

        try {
            //将外部配置信息读取到properties
            properties.load(is);

            //根据properties特性获取value值
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            //加载驱动
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //2.创建连接
    public static Connection createConn() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //3.释放连接
    public static void releaseConn(ResultSet rs , PreparedStatement ps, Connection conn){

        try {
            if( rs != null ){
                rs.close();
            }
        } catch (SQLException throwables) {
            rs = null;
        }
        try {
            if( ps != null ){
                ps.close();
            }
        } catch (SQLException throwables) {
            ps = null;
        }
        try {
            if( conn != null ){
                conn.close();
            }
        } catch (SQLException throwables) {
            conn = null;
        }

    }

    //4.执行查询SQL方法
    @Override
    public ResultSet query(String sql, Object[] params) throws SQLException {

        //创建sql执行对象
        ps = createConn().prepareStatement(sql);
        //绑定sql和参数.
        for(int i = 0 ; i < params.length ; i++ ){
            ps.setObject( i+1 , params[i] );
        }
        //执行sql。
        resultSet = ps.executeQuery();
        //返回结果.
        return resultSet;

    }

    //5.执行增删改SQL方法.
    @Override
    public int update(String sql, Object[] params) throws SQLException {
        //创建sql执行对象.
        ps= createConn().prepareStatement(sql);
        //绑定sql和参数.
        for(int i = 0 ; i < params.length ; i++ ){
            ps.setObject( i+1 ,  params[i] );
        }
        //执行sql。
        int i = ps.executeUpdate();
        //返回结果.
        return i;
    }
}
