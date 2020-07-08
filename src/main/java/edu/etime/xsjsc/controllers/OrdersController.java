package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.dao.ProductMapper;
import edu.etime.xsjsc.dto.CollectionProduct;
import edu.etime.xsjsc.dto.OrderProduct;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*订单管理Controller层
**/
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;
    @Autowired
    ProductMapper productMapper;


    //用户购物，新增订单，未支付
    @PostMapping("/addorders/nopay")
    public  Map<String,String> addorders(@RequestBody(required=false) Orders orders){
        ordersService.insert(orders,1);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert orders succeed");
        return map;
    }
    //用户购物，新增订单，已支付
    @PostMapping("/addorders/payed")
    public  Map<String,String> addordersPay(@RequestBody(required=false) Orders orders){
        ordersService.insert(orders,2);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert orders succeed");
        return map;
    }
    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Map<String, String> delete(@RequestParam(value="id",required=false)String id){
        ordersService.deleteOrders(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete orders succeed");
        return map;
    }


    //列出待付款订单
    @GetMapping("/listToPay")
    public List<OrderProduct> listToPay(String openid) {
        return ordersService.selectToPayOrders(openid);
    }

    //列出待发货订单
    @GetMapping("/listToSend")
    public List<OrderProduct> listToSend(String openid) {
        return ordersService.selectToSendOrders(openid);
    }

    //列出待收货订单
    @GetMapping("/listToReceive")
    public List<OrderProduct> listToReceive(String openid) {
        return ordersService.selectToReceiveOrders(openid);
    }

    //列出待退款订单
    @GetMapping("/listToBack")
    public List<OrderProduct> listToBack(String openid) {
        return ordersService.selectToBackOrders(openid);
    }

    //列出历史订单
    @GetMapping("/listHistory")
    public List<OrderProduct> listlishi(String openid) {
        return ordersService.selectHistoryOrders(openid);
    }

    /*请求退款state改为5**/
    @GetMapping("/askBackMoney")
    public Map<String, String> askBackMoney(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(5);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","ask back money succeed");
        return map;
    }

    /*用户退款修改state为0**/
    @GetMapping("/tuikuan")
    public Map<String, String> tuikuan(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(0);
        //退款后修改库存
        Product product = productMapper.selectByPrimaryKey(o.getProductid());
        product.setStock(product.getStock() + o.getNumber());
        productMapper.updateByPrimaryKeySelective(product);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","tuikuan succeed");
        return map;
    }




    /*取消订单修改state为0**/
    @GetMapping("/cancelorders")
    public Map<String, String> canceorders(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(0);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }

    /*去付款修改state为2**/
    @GetMapping("/payorders")
    public Map<String, String> payorders(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(2);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }

    /*管理员去发货修改state为3**/
    @GetMapping("/fahuo")
    public Map<String, String> fahuo(@RequestParam(value="id",required = false) String id,String invoice){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(3);
        o.setInvoice(invoice);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }

    /*确认收货 修改state为4**/
    @GetMapping("/shouhuo")
    public Map<String, String> shouhuo(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(4);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }
}
