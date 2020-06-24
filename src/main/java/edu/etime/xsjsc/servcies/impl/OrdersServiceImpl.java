package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.OrdersMapper;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/*订单服务层实现
**/
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public int insertOrders(Orders orders) {
        return ordersMapper.insertSelective(orders);
    }

    @Override
    public List<Orders> selectOrdersList() {
        return ordersMapper.selectOrdersList();
    }

    @Override
    public Orders selectOrdersById(String pid) {
        return ordersMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int updateOrders(Orders orders) {
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public int deleteOrders(String id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }
}
