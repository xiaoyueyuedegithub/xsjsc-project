package edu.etime.xsjsc.servcies.interfaces;


/**订单管理接口**/

import edu.etime.xsjsc.dto.BuyCarProduct;
import edu.etime.xsjsc.pojo.Buycar;

import java.util.List;

public interface BuyCarService {

    int insert(Buycar buycar);

    int deleteByPrimaryKey(String id);

    List<BuyCarProduct> selectBuycarList(String openid);

    int updateBuyCar(Buycar buycar);

    int payForGoods(String id);

    Integer deleteByOpenid(String openid);
}
