package edu.etime.xsjsc.controllers;


import edu.etime.xsjsc.pojo.CusAddress;
import edu.etime.xsjsc.servcies.interfaces.CusAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*地址管理Controller层
 **/
@RestController
@RequestMapping("/cusAddress")
public class CusAddressController {
    @Autowired
    CusAddressService cusAddressService;

    /**
     * 保存增加的地址
     *
     * @return
     */
    @PostMapping("/add")
    public Map<String, String> add(@RequestBody(required=false)CusAddress cusAddress){
        cusAddressService.insertCusAddress(cusAddress);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","insert cusAddress succeed");
        return map;
    }


    /**
     * 查询地址列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<CusAddress> list(){
        List<CusAddress> list = cusAddressService.selectCusAddressList();
        return list;
    }

    /**
     * 修改地址
     *
     * @param cusAddress
     * @return
     */
    @PutMapping("/edit")
    public Map<String, String> edit(@RequestBody(required=false) CusAddress cusAddress){
        cusAddressService.updateCusAddress(cusAddress);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","update cusAddress succeed");
        return map;
    }

    /**
     * 删除地址
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Map<String, String> delete(@RequestParam(value="id",required=false)String id){
        cusAddressService.deleteCusAddress(id);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        map.put("massage","delete cusAddress succeed");
        return map;
    }


}
