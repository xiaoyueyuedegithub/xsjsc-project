package edu.etime.xsjsc.controllers;



import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*订单管理Controller层
**/
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    /**
     * 保存增加的订单
     *
     * @return
     */
    @PostMapping("/add")
    public Map<String, String> add(@RequestBody(required=false) Orders orders){
        ordersService.insertOrders(orders);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert orders succeed");
        return map;
    }
    @PostMapping("/addorders")
    public  Map<String,String> addorders(@RequestBody(required=false) Orders orders){
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
        List<Orders> list2 = null;
        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if (list.get(i).getState()==1){
                list2.add(list.get(i));
            }
        }
        return list2;
    }


    /*查询待发货订单
     **/
    @GetMapping("/mylist3")
    public List<Orders> mylist3(String openid){
        //存放未发货订单
        List<Orders> list3 = null;
        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if (list.get(i).getState()==2){
                list3.add(list.get(i));
            }
        }
        return list3;
    }


    /*查询待收货订单
     **/
    @GetMapping("/mylist4")
    public List<Orders> mylist4(String openid){
        //存放待收货订单
        List<Orders> list4 = null;
        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if (list.get(i).getState()==3){
                list4.add(list.get(i));
            }
        }
        return list4;
    }



    /*取消订单修改state为0**/
    @PutMapping("/cancelorders")
    public Map<String, String> canceorders(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(0);
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
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }

    /*去发货修改state为3**/
    @PutMapping("/fahuo")
    public Map<String, String> fahuo(@RequestParam(value="id",required = false) String id){
        Orders o = ordersService.selectOrdersById(id);
        o.setState(3);
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
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
        return map;
    }


    /*查询历史订单state为0或者4的**/
    @GetMapping("/my")
    public List<Orders> my(String openid){
        //存放取消订单和已完成订单的list
        List<Orders> list1 = null;

        List<Orders> list =ordersService.selectByOpenid(openid);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getState()==0||list.get(i).getState()==4) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }
}
