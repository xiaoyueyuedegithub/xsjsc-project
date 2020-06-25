package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.CusAddressMapper;
import edu.etime.xsjsc.pojo.CusAddress;
import edu.etime.xsjsc.servcies.interfaces.CusAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusAddressServiceImpl implements CusAddressService {
    @Autowired
    CusAddressMapper cusAddressMapper;

    @Override
    public int insertCusAddress(CusAddress cusAddress) {
        return cusAddressMapper.insert(cusAddress);
    }

    @Override
    public List<CusAddress> selectCusAddressList() {
        return cusAddressMapper.selectCusAddressList();
    }

    @Override
    public List<CusAddress> selectAddress(String openid) {
        return cusAddressMapper.selectAddress(openid);
    }


    @Override
    public CusAddress selectCusAddressById(String pid) {
        return cusAddressMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int updateCusAddress(CusAddress cusAddress) {
        return cusAddressMapper.updateByOpenid(cusAddress);
    }

    @Override
    public int deleteCusAddress(String id) {
        return cusAddressMapper.deleteByPrimaryKey(id);
    }
}
