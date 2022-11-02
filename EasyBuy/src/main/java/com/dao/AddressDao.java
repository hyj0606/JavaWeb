package com.dao;

import com.pojo.Address;

import java.util.List;

public interface AddressDao extends BaseDao {
    int getCounts();

    List<Address> queryAllAddress(int m, int n);

    int del(Integer addressId);

    Address queryAddressById(Integer valueOf);

    int edit(Address address);

    int setUp(Integer id);

    int add(Address address);

    List<Address> queryId(Integer id);
}
