package edu.etime.xsjsc.servcies.interfaces;


/**订单管理接口**/

import edu.etime.xsjsc.pojo.Buycar;

public interface BuyCarService {

    int deleteByPrimaryKey(String id);

    int insert(Buycar record);

    int insertSelective(Buycar record);

    Buycar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Buycar record);

    int updateByPrimaryKey(Buycar record);

}
