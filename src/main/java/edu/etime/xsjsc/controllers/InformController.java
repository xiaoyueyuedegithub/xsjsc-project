package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.pojo.Inform;
import edu.etime.xsjsc.servcies.interfaces.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inform")
public class InformController {

    @Autowired
    InformService informService;

    //增加通知
    @PostMapping("/addinform")
    public  Map<String,String> addinform(@RequestBody(required=false) Inform inform){
        inform.setId((int) (Math.random()*(100)+1));
        informService.insert(inform);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert inform succeed");
        return map;
    }

    //删除通知
    @DeleteMapping("/deleteinform")
    public  Map<String,String> deleteinform(@RequestParam(value = "id",required = false) Integer id){
        informService.deleteinform(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete inform succeed");
        return map;
    }

    //修改通知
    @PutMapping("/updateinform")
    public  Map<String,String> updateinform(@RequestBody(required=false) Inform inform){
        informService.updateByPrimaryKeySelective(inform);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert inform succeed");
        return map;
    }

    //查询通知
    @GetMapping("/listinform")
    List<Inform> listinform(){
        List<Inform> list = informService.listselectinform();
        return list;
    }
}
