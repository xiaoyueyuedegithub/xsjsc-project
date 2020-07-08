package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.dto.CollectionProduct;
import edu.etime.xsjsc.pojo.Collection;
import edu.etime.xsjsc.servcies.interfaces.CollectionService;
import edu.etime.xsjsc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    @GetMapping("/collections/{openid}")
    public List<CollectionProduct> findCollections(@PathVariable("openid") String openid) {
        return collectionService.selectCollections(openid);
    }
    @PostMapping("/getCollectionByProductid")
    public Object findCollectionByProductid(@RequestBody Collection collection) {
        Collection collection1 = collectionService.findCollectionByProductid(collection);
        if(collection1 == null) {
            return ResultUtil.success(new Collection());
        }else {
            return ResultUtil.success(collection1);
        }
    }
    @DeleteMapping("/collection/{id}")
    public Integer deleteCollection(@PathVariable("id") String id) {
        return collectionService.deleteCollectionById(id);
    }
    @DeleteMapping("/collectionByProductid")
    public Object deleteCollection(String openid,String productid) {
        return ResultUtil.success(collectionService.deleteCollectionByProductid(productid,openid));
    }
    @PostMapping("/collection")
    public Integer addCollection(@RequestBody Collection collection) {
        collection.setId(UUID.randomUUID().toString());
        return collectionService.insertCollection(collection);
    }
}
