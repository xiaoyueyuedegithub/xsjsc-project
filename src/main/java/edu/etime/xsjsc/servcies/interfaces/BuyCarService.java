package edu.etime.xsjsc.servcies.interfaces;


/**订单管理接口**/

import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.Orders;

import java.util.List;

public interface BuyCarService {

    int insert(Buycar buycar);

    int deleteByPrimaryKey(String id);

    List<Buycar> selectBuycarList();

    int updateBuyCar(Buycar buycar);

    int payForGoods(String id);

}
