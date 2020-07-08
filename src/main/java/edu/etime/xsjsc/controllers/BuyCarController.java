package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buycar")
public class BuyCarController {

    @Autowired
    BuyCarService buyCarService;

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
    @PostMapping("/delete")
    public Map<String, String> deleteByPrimaryKey(@RequestParam(value="id",required=false)String id) {
        buyCarService.deleteByPrimaryKey(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete buycar succeed");
        return map;
    }

    /**
     * 查询购物车列表
     * @param id
     * @return
     */
    @PostMapping("/query")
    public Map<String, String> selectByPrimaryKey(@RequestParam(value="id",required=false)String id) {
        buyCarService.selectByPrimaryKey(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","query buycar succeed");
        return map;
    }

    /**
     * 修改购物车商品信息
     * @param record
     * @return
     */
    @PostMapping("/update")
    public Map<String, String> updateByPrimaryKey(@RequestParam(value="id",required=false)Buycar record) {
        buyCarService.updateByPrimaryKey(record);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update buycar succeed");
        return map;
    }

    @PostMapping("/pay")
    public Map<String, String> payForGoods(@RequestParam(value="id",required=false)String id) {
        buyCarService.payForGoods(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","pay buycar succeed");
        return map;
    }

}
