package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buycar")
public class BuyCarController {

    @Autowired
    BuyCarService buyCarService;

    /**点击增加购物车**/
    @PostMapping("/add")
    public Map<String, String> add(@RequestBody(required=false) Buycar buycar){
        buyCarService.insert(buycar);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert buycar succeed");
        return map;
    }


}
