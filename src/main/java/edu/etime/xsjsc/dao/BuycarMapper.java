package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Buycar;

import java.util.List;

public interface BuycarMapper {
    /**
     * 添加购物车接口
     * @param record
     * @return
     */
    int insert(Buycar buycar);

    /**
     * 删除购物车接口
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 查询购物车列表
     * @param id
     * @return
     */
    List<Buycar> selectBuycarList();

    /**
     * 修改购物车商品数量
     * @param buycar
     * @return
     */
    int updateByPrimaryKey(Buycar buycar);

    /**
     * 支付
     * @param id
     * @return
     */
    int payForGoods(String id);
}