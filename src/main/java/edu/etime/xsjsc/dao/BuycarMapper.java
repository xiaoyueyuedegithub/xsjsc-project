package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Buycar;

public interface BuycarMapper {
    /**
     * 添加购物车接口
     * @param record
     * @return
     */
    int insert(Buycar record);

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
    Buycar selectByPrimaryKey(String id);

    /**
     * 修改购物车商品数量
     * @param record
     * @return
     */
    int updateByPrimaryKey(Buycar record);

    /**
     * 支付
     * @param id
     * @return
     */
    int payForGoods(String id);
}