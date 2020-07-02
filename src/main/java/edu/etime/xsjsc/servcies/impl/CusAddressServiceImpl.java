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
        Integer isDefault = cusAddress.getIsdefault();
        //1、判断需要新增的收货地址是否是默认收货地址
        if(isDefault==1){
            //2、如果是默认收货地址，那么将原来的地址全部修改为非默认地址
            CusAddress addr = new CusAddress();
            addr.setOpenid(cusAddress.getOpenid());
            addr.setIsdefault(0);
            cusAddressMapper.updateByOpenid(addr);
        }
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
