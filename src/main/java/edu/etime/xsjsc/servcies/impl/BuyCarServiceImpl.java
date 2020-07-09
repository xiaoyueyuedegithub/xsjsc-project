package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.dao.ProductMapper;
import edu.etime.xsjsc.dto.BuyCarProduct;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.servcies.interfaces.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuyCarServiceImpl implements BuyCarService {

    @Autowired
    BuycarMapper buycarMapper;
    @Autowired
    ProductMapper productMapper;

    @Override
    public int insert(Buycar buycar) {
        buycar.setId(UUID.randomUUID().toString());
        return buycarMapper.insert(buycar);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return buycarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<BuyCarProduct> selectBuycarList(String openid) {
        List<Buycar> buycars = buycarMapper.selectBuycarList(openid);
        List<BuyCarProduct> list = new ArrayList<>();
        for(int i = 0;i < buycars.size();i++) {
            BuyCarProduct buyCarProduct = new BuyCarProduct(buycars.get(i));
            Product product = productMapper.selectByPrimaryKey(buycars.get(i).getProductid());
            buyCarProduct.setProduct(product);
            list.add(buyCarProduct);
        }
        return list;
    }

    @Override
    public int updateBuyCar(Buycar buycar) {
        return buycarMapper.updateByPrimaryKey(buycar);
    }

    @Override
    public int payForGoods(String id) { return buycarMapper.payForGoods(id); }

    @Override
    public Integer deleteByOpenid(String openid) {
        return buycarMapper.deleteByOpenid(openid);
    }
}
