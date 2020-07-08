package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.dao.OrdersMapper;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.CusAddress;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyCarServiceImpl implements BuyCarService {

    @Autowired
    BuycarMapper buycarMapper;
    OrdersMapper ordersMapper;

    @Override
    public int insert(Buycar buycar) {
        return buycarMapper.insert(buycar);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return buycarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Buycar> selectBuycarList() {
        return buycarMapper.selectBuycarList();
    }

    @Override
    public int updateBuyCar(Buycar buycar) {
        return buycarMapper.updateByPrimaryKey(buycar);
    }

    @Override
    public int payForGoods(String id) { return buycarMapper.payForGoods(id); }
}
