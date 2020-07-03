package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    /*查询订单列表
    **/
    List<Orders> selectOrdersList();


     /*根据用户id状态搜索订单**/
     List<Orders> selectByopenid(String openid);

    int deleteByPrimaryKey(String id);

    /*根据商品id插入订单**/
    int insert(Orders orders);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}