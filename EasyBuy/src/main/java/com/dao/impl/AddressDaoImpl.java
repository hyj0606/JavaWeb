package com.dao.impl;

import com.dao.AddressDao;
import com.pojo.Address;
import com.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AddressDaoImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-19 8:54
 * @Version 1.0
 */

public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

    @Override
    public List<Address> queryAllAddress(int m, int n) {
        /*SELECT u.`user_name`,u.`sex`, u.`mobile`,u.`email`, d.`address`
        FROM `easybuy_user` u , `easybuy_user_address` d
        WHERE d.`user_id` = u.`id` LIMIT 0,5;*/

        String sql = "SELECT u.`user_name`,u.`sex`, u.`mobile`,u.`email`,d.`id`, d.`address`,d.`tel`,d.`is_default`, d.`remark` FROM `easybuy_user` u , `easybuy_user_address` d WHERE d.`user_id` = u.`id` LIMIT ?,? ";

        Object[] params = {m,n};

        try {
            resultSet = query(sql,params);

            List<Address> addressList = new ArrayList();

            while (resultSet.next()){
                String userName = resultSet.getString("user_name");
                int sex = resultSet.getInt("sex");
                String mobile = resultSet.getString("mobile");
                String email = resultSet.getString("email");
                User user = new User();
                user.setUserName(userName);
                user.setSex(sex);
                user.setMobile(mobile);
                user.setEmail(email);

                int id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                String tel = resultSet.getString("tel");
                String remark = resultSet.getString("remark");
                int isDefault = resultSet.getInt("is_default");
                Address address1 = new Address();
                address1.setId(id);
                address1.setAddress(address);
                address1.setTel(tel);
                address1.setRemark(remark);
                address1.setIsDefault(isDefault);
                address1.setUser(user);

                addressList.add(address1);
            }
            return addressList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }

        return null;
    }

    @Override
    public int del(Integer addressId) {

        String sql = " DELETE FROM `easybuy_user_address` WHERE id = ? ";

        Object[] params = { addressId };

        try {
            int result = update(sql, params);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return -1;

    }

    @Override
    public Address queryAddressById(Integer valueOf) {

        /*
         * SELECT u.`user_name`,u.`sex`, u.`mobile`,u.`email`,d.`id`, d.`address`,d.`is_default`, d.`remark`
         * FROM `easybuy_user` u , `easybuy_user_address` d
         * WHERE d.`user_id` = u.`id` AND d.`id`=12;
         * */

        //sql和参数
        String sql = " SELECT u.`user_name`,u.`sex`, u.`mobile`,u.`email`,d.`id`, d.`address`,d.`is_default`, d.`remark` FROM `easybuy_user` u , `easybuy_user_address` d WHERE d.`user_id` = u.`id` AND d.`id`= ? ";

        Object[] params = {
                valueOf
        };

        try {
            resultSet = query(sql, params);

            if (resultSet.next()){
                //商品对象属性:
                String userName = resultSet.getString("user_name");
                int sex = resultSet.getInt("sex");
                String mobile = resultSet.getString("mobile");
                String email = resultSet.getString("email");
                User user = new User();
                user.setUserName(userName);
                user.setSex(sex);
                user.setMobile(mobile);
                user.setEmail(email);

                int id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                String remark = resultSet.getString("remark");
                int isDefault = resultSet.getInt("is_default");
                Address address1 = new Address();
                address1.setId(id);
                address1.setAddress(address);
                address1.setRemark(remark);
                address1.setIsDefault(isDefault);
                address1.setUser(user);
                return address1;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            releaseConn(resultSet,ps,conn);
        }
    }

    @Override
    public int edit(Address address) {

        /*  UPDATE `easybuy_user_address` a ,`easybuy_user` u
            SET  a.`address`='合肥市蜀山区', a.`remark`='家里',u.`mobile`='173',u.`mobile`=
            WHERE a.`user_id`=u.`id` AND a.`id`=12;*/

        String sql = "UPDATE `easybuy_user_address` a ,`easybuy_user` u SET  a.`address` = ? , a.`remark` = ? , u.`mobile` = ? , u.`email`= ?  WHERE a.`user_id`=u.`id` AND a.`id`=? ";

        Object[] params = {
                address.getAddress(),
                address.getRemark(),
                address.getUser().getMobile(),
                address.getUser().getEmail(),
                address.getId()
        };

        try {
            int result = update(sql, params);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return -1;
    }

    @Override
    public int setUp(Integer id) {

        /*UPDATE `easybuy_user_address` a1, `easybuy_user_address` a2
        SET a1.`is_default`=0, a2.`is_default`=1 WHERE a2.`id`=12;*/
        String sql = " UPDATE `easybuy_user_address` a1, `easybuy_user_address` a2 SET a1.`is_default`=0, a2.`is_default`=1 WHERE a2.`id`= ? ";

        Object[] params = {
                id
        };

        try {
            int result = update(sql,params);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return -1;
    }

    @Override
    public int add(Address address) {
        String sql = "INSERT INTO easybuy_user_address (user_id , address, tel , remark ) VALUES (?, ? , ? , ? ) ";

        Object[] params = {
                address.getUser().getId(),
                address.getAddress(),
                address.getTel(),
                address.getRemark()
        };

        try {
            int result = update(sql, params);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return -1;
    }

    @Override
    public List<Address> queryId(Integer id) {

        String sql = " SELECT u.`user_name`, u.`email`, ua.`id` ,ua.`address`, ua.`tel`,ua.`remark` FROM `easybuy_user_address` ua, `easybuy_user` u WHERE ua.`user_id`=u.`id` AND user_id=? ";

        Object[] params = {id};

        try {
            resultSet = query(sql,params);

            List<Address> addressList = new ArrayList<>();

            while (resultSet.next()){
                String userName = resultSet.getString("user_name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String tel = resultSet.getString("tel");
                String remark = resultSet.getString("remark");
                int id1 = resultSet.getInt("id");
                User user = new User();
                user.setUserName(userName);
                user.setEmail(email);
                Address address1 = new Address();
                address1.setAddress(address);
                address1.setTel(tel);
                address1.setRemark(remark);
                address1.setUser(user);
                address1.setId(id1);

                addressList.add(address1);

            }
            return addressList;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return null;
    }

    @Override
    public int getCounts() {


        String sql = "SELECT COUNT(0) FROM `easybuy_user_address`";

        Object[] params = {};

        try {
            resultSet = query(sql,params);
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                return count;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseConn(resultSet,ps,conn);
        }
        return 0;
    }

}
