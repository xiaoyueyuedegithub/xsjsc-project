package edu.etime.xsjsc.servcies.interfaces;


/**订单管理接口**/

import edu.etime.xsjsc.pojo.Buycar;

public interface BuyCarService {

    int insert(Buycar record);

    int deleteByPrimaryKey(String id);

    Buycar selectByPrimaryKey(String id);

    int updateByPrimaryKey(Buycar record);

    int payForGoods(String id);

}
