package com.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class BaseDao {
	//定义全局属性:
	static String driver = null;
	static String url = null;
	static String user = null;
	static String password = null;

	//JDBC API  全局属性:
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet set = null;


	static {

		//加载完成配置文件:
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		Properties pro = new Properties();


		try {
			//加载输入流数据到当前集合中.
			pro.load( is );

			//解析集合中的数据:
			driver = String.valueOf(  pro.get( "jdbc.driver" ) );
			url = String.valueOf(  pro.get( "jdbc.url" ) );
			user = String.valueOf(  pro.get( "jdbc.user" ) );
			password = String.valueOf(  pro.get( "jdbc.password" ) );

		} catch (IOException e1) {
			System.out.println("配置文件初始化失败,请关闭重启程序!!!");
		}

		try {
			Class.forName( driver );
		} catch (ClassNotFoundException e) {
			System.out.println("驱动程序找不到，故加载失败!!!");
		}
	}

	//2.静态方法:   建立连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("连接建立失败,请重试!!!");
		}
		return conn;
	}

	//3.静态方法:   释放资源
	public static void closeResource(ResultSet set , Statement stmt , Connection conn) {

		if( set != null ) {
			try {
				set.close();
			} catch (SQLException e) {
				set = null;
			}
		}

		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				stmt = null;
			}
		}

		if( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
				conn = null;
			}
		}
	}

	//编写查询功能:
	public ResultSet query(String sql , Object[] params) {
		try {
			//可能产生异常的代码块:
			//1.加载驱动.
			//2.建立连接: 通过Jdbc工具类即可.
			conn = getConnection();

			//3.编写sql.

			//4.创建一个预编译执行对象, 先绑定参数与, 再执行sql.
			pstm = conn.prepareStatement(sql);

			//绑定参数数组到预编译对象中:
			for (int i = 0; i < params.length; i++) {
				pstm.setObject( i+1 , params[i]);
			}

			//set即为查询结果: 临时数据表.
			set = pstm.executeQuery();

			return set;
		}catch( Exception e1 ) {
			System.out.println("报错拉...");
			return null;
		}
	}

	//编写增删改功能:
	public int executeUpdate( String sql , Object[] params ){
		try {
			//可能产生异常的代码块:
			//1.加载驱动.
			//2.建立连接: 通过Jdbc工具类即可.
			conn = getConnection();

			//3.编写sql.

			//4.创建一个预编译执行对象, 先绑定参数与, 再执行sql.
			pstm = conn.prepareStatement(sql);

			//绑定参数数组到预编译对象中:
			for (int i = 0; i < params.length; i++) {
				pstm.setObject( i+1 , params[i]);
			}

			int r = pstm.executeUpdate();

			return r;
		}catch( Exception e1 ) {
			System.out.println("报错拉...");
			return -1;
		}finally {
			closeResource(set, pstm, conn);
		}
	}
}
