package edu.etime.xsjsc.controllers;

import java.util.List;
import java.util.UUID;

import edu.etime.xsjsc.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.etime.xsjsc.pojo.GoodsType;
import edu.etime.xsjsc.dto.GoodsTypeProduct;
import edu.etime.xsjsc.dto.ProductDetailDto;
import edu.etime.xsjsc.pojo.CusAddress;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.servcies.interfaces.WXDataService;

/**
 * 微信数据接口controller层
 * @author 张旺
 *
 */
@RestController
@RequestMapping("/wx")
public class WXDataController {

	@Autowired
	private WXDataService service;
	
	/**
	 * 首页商品列表显示
	 * cmd=recommend:精选推荐
	 * cmd=oldest：最新产品
	 * cmd=hot：热销产品
	 * @param cmd
	 * @return
	 */

	@GetMapping("/index/{cmd}")
	@ResponseBody
	public List<Product> selectIndexProduct(@PathVariable("cmd")String cmd){
		Product p = new Product();
		p.setFields1("1");
		if(cmd.equals("recommend")){
			p.setRecommend(1);
		}else if(cmd.equals("oldest")){
			p.setOldest(1);
		}else if(cmd.equals("hot")){
			p.setHot(1);
		}
		List<Product> list = service.selectProductList(p);
		return list;
	}
	
	/**
	 * 查询分类商品列表
	 * @return
	 */
	@GetMapping("/product")
	@ResponseBody
	public List<GoodsTypeProduct> selectGoodsTypeProduct(){
		return service.selectGoodsTypeProduct();
	}

	/**
	 * 查询商品的详情
	 * @param id
	 * @return
	 */
	@GetMapping("/detail/{id}")
	@ResponseBody
	public ProductDetailDto selectProductDetails(@PathVariable("id")String id){		
		return service.selectProductDetails(id);
	}
	/**
	 * 根据openid查询用户的收货地址列表
	 * @param openid
	 * @return
	 */
	@GetMapping("/getaddr/{openid}")
	@ResponseBody
	public List<CusAddress> selectCusAddress(@PathVariable("openid")String openid){
		CusAddress addr = new CusAddress();
		addr.setOpenid(openid);
		return service.selectCusAddress(addr);
	}
	/**
	 * 增加收货地址
	 * @param address
	 * @return
	 */
	@PostMapping(value="/address/add")
	@ResponseBody
	public int insertCusAddress(@RequestBody CusAddress address){
		address.setId(UUID.randomUUID().toString());
		return service.insertCusAddress(address);
	}

}
