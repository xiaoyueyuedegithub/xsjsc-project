package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.servcies.interfaces.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyCarImpl implements BuyCarService {

    @Autowired
    BuycarMapper buycarMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return buycarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Buycar record) {
        return 0;
    }

    @Override
    public int insertSelective(Buycar record) {
        return 0;
    }

    @Override
    public Buycar selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Buycar record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Buycar record) {
        return 0;
    }
}
