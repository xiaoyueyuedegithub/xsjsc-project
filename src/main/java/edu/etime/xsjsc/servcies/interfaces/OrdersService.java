package edu.etime.xsjsc.servcies.interfaces;



/*订单管理接口
**/

import edu.etime.xsjsc.pojo.Orders;

import java.util.List;

public interface OrdersService {

    /*根据商品id增加订单**/
    int insert(Orders orders);

    /**
     * 增加订单
     * @param orders
     * @return
     */
    int insertOrders(Orders orders);
    /**
     * 查询订单列表
     * @return
     */
    List<Orders> selectOrdersList();

    /**
     * 根据用户id查询订单列表
     * @return
     */
    List<Orders> selectByOpenid(String openid);
    /**
     * 根据商品id查询一条商品的详细信息
     * @param pid
     * @return
     */
    Orders selectOrdersById(String pid);

    /**
     * 修改订单列表
     * @param orders
     * @return
     */
    int updateOrders(Orders orders);


    /**
     * 删除订单信息
     * @param id
     * @return
     */
    int deleteOrders(String id);
}
