package edu.etime.xsjsc.servcies.interfaces;

import edu.etime.xsjsc.dto.CollectionProduct;
import edu.etime.xsjsc.pojo.Collection;

import java.util.List;

public interface CollectionService {
    /**
     * 查询用户的收藏列表
     * @param openid
     * @return
     */
    List<CollectionProduct> selectCollections(String openid);

    /**
     * 根据id删除收藏
     * @param id
     * @return
     */
    Integer deleteCollectionById(String id);

    /**
     * 插入收藏
     * @param collection
     * @return
     */
    Integer insertCollection(Collection collection);
}
