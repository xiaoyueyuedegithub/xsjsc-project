package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.CollectionMapper;
import edu.etime.xsjsc.dao.ProductMapper;
import edu.etime.xsjsc.dto.CollectionProduct;
import edu.etime.xsjsc.pojo.Collection;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.servcies.interfaces.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class
CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<CollectionProduct> selectCollections(String openid) {
        List<CollectionProduct> collectionProducts = new ArrayList<>();
        List<Collection> collections = collectionMapper.selectByOpenid(openid);
        for(Collection collection:collections) {
            CollectionProduct collectionProduct = new CollectionProduct();
            collectionProduct.setId(collection.getId());
            collectionProduct.setCollecttime(collection.getCollecttime());
            Product product = productMapper.selectByPrimaryKey(collection.getProductid());
            collectionProduct.setProduct(product);
            collectionProducts.add(collectionProduct);
        }
        return collectionProducts;
    }

    @Override
    public Integer deleteCollectionById(String id) {
        return collectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insertCollection(Collection collection) {
        return collectionMapper.insertSelective(collection);
    }
}
