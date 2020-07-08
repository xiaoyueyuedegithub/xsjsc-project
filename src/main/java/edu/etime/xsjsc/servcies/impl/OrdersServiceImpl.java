package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.OrdersMapper;
import edu.etime.xsjsc.dao.ProductMapper;
import edu.etime.xsjsc.dto.OrderProduct;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/*订单服务层实现
**/
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    ProductMapper productMapper;

   //返回待付款订单
    @Override
    public List<OrderProduct> selectToPayOrders(String openid) {
        List<OrderProduct> list1 = new ArrayList<>();
        if(openid!=null){
            List<Orders> list = ordersMapper.selectByopenid(openid);
            for(Orders orders1:list){
                if (orders1.getState()==1){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list1.add(orderProduct);
                }
            }
        }else {
            List<Orders> list = ordersMapper.selectOrdersList();
            for(Orders orders1:list){
                if (orders1.getState()==1){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list1.add(orderProduct);
                }
            }
        }
        return list1;
    }

    //列出待发货
    @Override
    public List<OrderProduct> selectToSendOrders(String openid) {
        List<OrderProduct> list2 = new ArrayList<>();
        if(openid!=null){
            List<Orders> list = ordersMapper.selectByopenid(openid);
            for(Orders orders1:list){
                if (orders1.getState()==2){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list2.add(orderProduct);
                }
            }
        }else {
            List<Orders> list = ordersMapper.selectOrdersList();
            for(Orders orders1:list){
                if (orders1.getState()==2){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list2.add(orderProduct);
                }
            }
        }
        return list2;
    }

    //列出待收货
    @Override
    public List<OrderProduct> selectToReceiveOrders(String openid) {
        List<OrderProduct> list3 = new ArrayList<>();
        if(openid!=null){
            List<Orders> list = ordersMapper.selectByopenid(openid);
            for(Orders orders1:list){
                if (orders1.getState()==3){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    orderProduct.setInvoice(orders1.getInvoice());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list3.add(orderProduct);
                }
            }
        }else {
            List<Orders> list = ordersMapper.selectOrdersList();
            for(Orders orders1:list){
                if (orders1.getState()==1){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    orderProduct.setInvoice(orders1.getInvoice());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list3.add(orderProduct);
                }
            }
        }
        return list3;
    }
    //列出待退款商品
    @Override
    public List<OrderProduct> selectToBackOrders(String openid) {
        List<OrderProduct> list3 = new ArrayList<>();
        if(openid!=null){
            List<Orders> list = ordersMapper.selectByopenid(openid);
            for(Orders orders1:list){
                if (orders1.getState()==5){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list3.add(orderProduct);
                }
            }
        }else {
            List<Orders> list = ordersMapper.selectOrdersList();
            for(Orders orders1:list){
                if (orders1.getState()==5){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list3.add(orderProduct);
                }
            }
        }
        return list3;
    }

    //列出历史订单
    @Override
    public List<OrderProduct> selectHistoryOrders(String openid) {
        List<OrderProduct> list4 = new ArrayList<>();
        if(openid!=null){
            List<Orders> list = ordersMapper.selectByopenid(openid);
            for(Orders orders1:list){
                if (orders1.getState()==0||orders1.getState()==4){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    orderProduct.setInvoice(orders1.getInvoice());
                    orderProduct.setState(orders1.getState());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list4.add(orderProduct);
                }
            }
        }else {
            List<Orders> list = ordersMapper.selectOrdersList();
            for(Orders orders1:list){
                if (orders1.getState()==0||orders1.getState()==4){
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setId(orders1.getId());
                    orderProduct.setNumber(orders1.getNumber());
                    orderProduct.setAddress(orders1.getAddress());
                    orderProduct.setInvoice(orders1.getInvoice());
                    orderProduct.setState(orders1.getState());
                    Product product = productMapper.selectByPrimaryKey(orders1.getProductid());
                    orderProduct.setProduct(product);
                    list4.add(orderProduct);
                }
            }
        }
        return list4;
    }


    @Override
    public int insert(Orders orders,Integer state) {
        orders.setState(state);
        //增加订单后商品库存减少
        Product product = productMapper.selectByPrimaryKey(orders.getProductid());
        product.setStock(product.getStock() - orders.getNumber());
        productMapper.updateByPrimaryKeySelective(product);
        return ordersMapper.insert(orders);
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
