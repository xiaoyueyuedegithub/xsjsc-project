package edu.etime.xsjsc.controllers;



import edu.etime.xsjsc.dao.ProductMapper;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


    //用户购物，新增订单
    @PostMapping("/addorders")
    public  Map<String,String> addorders(@RequestBody(required=false) Orders orders){
        orders.setPrice(productMapper.selectByPrimaryKey(orders.getProductid()).getPrice());
        orders.setProductname(productMapper.selectByPrimaryKey(orders.getProductid()).getName());
        orders.setTitle(productMapper.selectByPrimaryKey(orders.getProductid()).getTitle());
        ordersService.insert(orders);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert orders succeed");
        return map;
    }


    /**
     * 查询订单列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<Orders> list(){
        List<Orders> list = ordersService.selectOrdersList();
        return list;
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

    /*查询待付款订单
    **/
    @GetMapping("/mylist2")
    public List<Orders> mylist2(String openid){
        //存放未付款订单
        List<Orders> list2 = new ArrayList<Orders>();
        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if (list.get(i).getState()==1){
                list2.add(list.get(i));
            }
        }
        return list2;
    }


    /*返回待付款商品详情**/
    @PostMapping("listproduct1")
    List<Product> listprouct1(@RequestBody(required=false) Orders orders){
        //存放待付款的产品信息
        List<Product> p1 = new ArrayList<Product>();
        List<Orders> list =ordersService.selectByOpenid(orders.getOpenid());
        for(int i=0;i<list.size();i++) {
            if (list.get(i).getState() == 1) {
                p1.add(productMapper.selectByPrimaryKey(orders.getProductid()));
            }
        }
        return p1;
    }


    /*查询待发货订单
     **/
    @GetMapping("/mylist3")
    public List<Orders> mylist3(String openid){
        //存放未发货订单
        List<Orders> list3 =new ArrayList<Orders>();
        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if (list.get(i).getState()==2){
                list3.add(list.get(i));
            }
        }
        return list3;
    }

    /*返回待发货商品详情**/
    @PostMapping("listproduct2")
    List<Product> listprouct2(@RequestBody(required=false) Orders orders){
        //存放待发货的产品信息
        List<Product> p2 = new ArrayList<Product>();
        List<Orders> list =ordersService.selectByOpenid(orders.getOpenid());
        for(int i=0;i<list.size();i++) {
            if (list.get(i).getState() == 2) {
                p2.add(productMapper.selectByPrimaryKey(orders.getProductid()));
            }
        }
        return p2;
    }

    /*用户退款修改state为0**/
    @PutMapping("/tuikuan")
    public Map<String, String> tuikuan(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(0);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","tuikuan succeed");
        return map;
    }

    /*查询待收货订单
     **/
    @GetMapping("/mylist4")
    public List<Orders> mylist4(String openid){
        //存放待收货订单
        List<Orders> list4 = new ArrayList<Orders>();
        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if (list.get(i).getState()==3){
                list4.add(list.get(i));
            }
        }
        return list4;
    }

    /*返回待收货商品详情**/
    @PostMapping("listproduct3")
    List<Product> listprouc3(@RequestBody(required=false) Orders orders){
        //存放待收货的产品信息
        List<Product> p3 = new ArrayList<Product>();
        List<Orders> list =ordersService.selectByOpenid(orders.getOpenid());
        for(int i=0;i<list.size();i++) {
            if (list.get(i).getState() == 3) {
                p3.add(productMapper.selectByPrimaryKey(orders.getProductid()));
            }
        }
        return p3;
    }


    /*取消订单修改state为0**/
    @PutMapping("/cancelorders")
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
    @PutMapping("/payorders")
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
    /*前端传一个order对象**/
    @PutMapping("/fahuo")
    public Map<String, String> fahuo(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(3);
        o.setInvoice(o.getInvoice());
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }

    /*确认收货 修改state为4**/
    @PutMapping("/shouhuo")
    public Map<String, String> shouhuo(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(4);
        ordersService.updateOrders(o);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }


    /*查询历史订单state为0或者4的**/
    @GetMapping("/my")
    public List<Orders> my(String openid){
        //存放取消订单和已完成订单的list
        List<Orders> list1 = new ArrayList<Orders>();
        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getState()==0||list.get(i).getState()==4) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }

    /*返回全部订单商品详情**/
    @PostMapping("listproduct4")
    List<Product> listprouct4(@RequestBody(required=false) Orders orders){
        //存放我的订单的产品信息
        List<Product> p4 = new ArrayList<Product>();
        List<Orders> list =ordersService.selectByOpenid(orders.getOpenid());
        for(int i=0;i<list.size();i++) {
            if (list.get(i).getState() == 0||list.get(i).getState() == 4) {
                p4.add(productMapper.selectByPrimaryKey(orders.getProductid()));
            }
        }
        return p4;
    }

}
