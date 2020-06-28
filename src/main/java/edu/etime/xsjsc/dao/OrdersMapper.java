package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    /*查询订单列表
    **/
    List<Orders> selectOrdersList();

    /*根据用户id查询订单
    **/
     List<Orders> selectByOpenid(String openid);

    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}