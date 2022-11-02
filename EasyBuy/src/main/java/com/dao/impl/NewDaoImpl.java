package com.dao.impl;

import com.dao.BaseDao;
import com.dao.NewDao;
import com.pojo.New;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NewDaoImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-20 15:02
 * @Version 1.0
 */

public class NewDaoImpl extends BaseDaoImpl implements NewDao {
    @Override
    public List<New> queryAll() {
        String sql = " SELECT * FROM `easybuy_news` ORDER BY create_time DESC LIMIT 5 ";

        Object[] params = {};

        List<New> newList = new ArrayList<>();

        try {
            resultSet = query(sql,params);

            while (resultSet.next()){

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String createTime = resultSet.getString("create_time");

                New aNew = new New(id,title,content,createTime);

                newList.add(aNew);
            }
            return newList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;
    }
}
