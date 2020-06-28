package edu.etime.xsjsc.servcies.interfaces;


import edu.etime.xsjsc.pojo.CusAddress;

import java.util.List;

public interface CusAddressService {
    /**
     * 增加地址
     * @param cusAddress
     * @return
     */
    int insertCusAddress(CusAddress cusAddress);
    /**
     * 查询地址列表
     * @return
     */
    List<CusAddress> selectCusAddressList();

    /**
     * 根据用户id查询地址列表
     * @return
     */
    List<CusAddress> selectAddress(String openid);

    /**
     * 根据地址id查询一条地址详细信息
     * @param pid
     * @return
     */
    CusAddress selectCusAddressById(String pid);

    /**
     * 修改地址列表
     * @param cusAddress
     * @return
     */
    int updateCusAddress(CusAddress cusAddress);

    /**
     * 删除地址信息
     * @param id
     * @return
     */
    int deleteCusAddress(String id);
}
