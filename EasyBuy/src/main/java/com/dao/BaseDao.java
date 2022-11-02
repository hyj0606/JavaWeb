package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseDao {

    //查询功能:
    public ResultSet query(String sql, Object[] params) throws SQLException;

    //增删改功能:
    public int update(String sql, Object[] params) throws SQLException;

}
