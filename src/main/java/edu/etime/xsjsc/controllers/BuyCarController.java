package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.CusAddress;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.BuyCarService;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buycar")
public class BuyCarController {

    @Autowired
    BuyCarService buyCarService;
    OrdersService ordersService;

    /**
     * 点击增加购物车
     * @param buycar
     * @return
     */
    @PostMapping("/add")
    public Map<String, String> add(@RequestBody(required=false) Buycar buycar) {
        buyCarService.insert(buycar);
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        map.put("massage", "insert buycar succeed");
        return map;
    }

    /**
     * 根据主键删除购物车数据
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Map<String, String> delete(@RequestParam(value="id",required=false)String id) {
        buyCarService.deleteByPrimaryKey(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete buycar succeed");
        return map;
    }

    /**
     * 查询购物车列表
     * @param
     * @return
     */
    @GetMapping("/query")
    public List<Buycar> list(){
        List<Buycar> list = buyCarService.selectBuycarList();
        return list;
    }

    /**
     * 修改购物车商品数量信息
     * @param buycar
     * @return
     */
    @PutMapping("/update")
    public Map<String, String> update(@RequestBody(required=false)Buycar buycar) {
        buyCarService.updateBuyCar(buycar);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update buycar succeed");
        return map;
    }

    /**
     * 支付时把购物车的数据从数据库中删除掉，再把这条数据插入待付款/待发货的数据库
     * @param id
     * @return
     */
    @PostMapping("/pay")
    public Map<String, String> pay(@RequestParam(value="id",required=false)String id) {
        Orders orders = null;
        buyCarService.payForGoods(id);

        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","pay buycar succeed");
        return map;
    }

}
