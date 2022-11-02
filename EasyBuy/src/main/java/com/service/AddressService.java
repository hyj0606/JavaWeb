package com.service;

import com.pojo.Address;
import com.pojo.Page;

import java.util.List;

public interface AddressService {
    Page queryAll(int pNo, int pSize);

    int del(Integer addressId);

    Address queryById(Integer valueOf);

    int edit(Address address);

    int setUp(Integer valueOf);

    int add(Address address);

    List<Address> queryId(Integer id);
}
