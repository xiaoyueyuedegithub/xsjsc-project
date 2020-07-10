package edu.etime.xsjsc.dao;

import java.util.List;

import edu.etime.xsjsc.pojo.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    /**
     * 查询商品列表
     * @param p
     * @return
     */
    List<Product> selectProductList(Product p);
    List<Product> selectProductList1();

    /**
     * 关键词搜索
     * @param keyword
     * @return
     */
    List<Product> selectByKeyWord(@Param("keyword")String keyword);
}