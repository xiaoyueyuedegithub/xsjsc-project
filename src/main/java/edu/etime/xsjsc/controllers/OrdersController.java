package edu.etime.xsjsc.controllers;



import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 修改订单
     *
     * @param orders
     * @return
     */
    @PutMapping("/edit")
    public Map<String, String> edit(@RequestBody(required=false) Orders orders){
        ordersService.updateOrders(orders);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update orders succeed");
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

    /*我的订单
    **/
    @GetMapping("/my")
    public List<Orders> my(String openid){
        List<Orders> list =ordersService.selectByOpenid(openid);
        return list;
    }
}
