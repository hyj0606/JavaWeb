package com.service.impl;

import com.dao.AddressDao;
import com.dao.impl.AddressDaoImpl;
import com.pojo.Address;
import com.pojo.Order;
import com.pojo.Page;
import com.service.AddressService;

import java.util.List;

/**
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author hyj98
 * @Date 2022-10-19 8:47
 * @Version 1.0
 */

public class AddressServiceImpl implements AddressService {
    AddressDao addressDao = new AddressDaoImpl();
    @Override
    public Page queryAll(int pNo, int pSize) {
        //创建Page对象
        Page page = new Page();

        //先存储每页大小到page中
        page.setPageSize(pSize);

        //1.按照条件查询---->查询总记录数
        int count = addressDao.getCounts();
        page.setTotalCount(count);

        //存储当前页码到page中
        page.setPageNo(pNo);

        //2.查询商品,完成分页查询
        List<Address> addressList = addressDao.queryAllAddress((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());

        //封装查询结果到Page对象中:
        page.setResults(addressList);

        //返回page对象
        return page;
    }

    @Override
    public int del(Integer addressId) {

        int result = addressDao.del(addressId);

        return result;

    }

    @Override
    public Address queryById(Integer valueOf) {

        return this.addressDao.queryAddressById(valueOf);

    }

    @Override
    public int edit(Address address) {

        int result = addressDao.edit(address);

        return result;
    }

    @Override
    public int setUp(Integer id) {

        int result = addressDao.setUp(id);

        return result;
    }

    @Override
    public int add(Address address) {
        int result = addressDao.add(address);

        return result;
    }

    @Override
    public List<Address> queryId(Integer id) {

        List<Address> addressList = addressDao.queryId(id);

        return addressList;

    }
}
