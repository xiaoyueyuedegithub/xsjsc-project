package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.servcies.interfaces.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyCarServiceImpl implements BuyCarService {

    @Autowired
    BuycarMapper buycarMapper;

    @Override
    public int insert(Buycar record) {
        return buycarMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return buycarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Buycar selectByPrimaryKey(String id) {
        return buycarMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Buycar record) {
        return buycarMapper.updateByPrimaryKey(record);
    }

    @Override
    public int payForGoods(String id) { return buycarMapper.payForGoods(id); }
}
