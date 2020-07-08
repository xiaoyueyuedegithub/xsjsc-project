package edu.etime.xsjsc.servcies.interfaces;



/*订单管理接口
**/

import edu.etime.xsjsc.dto.OrderProduct;
import edu.etime.xsjsc.pojo.Orders;

import java.util.List;

public interface OrdersService {


    /*列出待付款产品**/
    List<OrderProduct> selectToPayOrders(String openid);
    /*列出待发货产品**/
    List<OrderProduct> selectToSendOrders(String openid);
    /*列出待收货产品**/
    List<OrderProduct> selectToReceiveOrders(String openid);
    /*列出历史订单产品**/
    List<OrderProduct> selectHistoryOrders(String openid);


    /*根据商品id增加订单**/
    int insert(Orders orders);
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
