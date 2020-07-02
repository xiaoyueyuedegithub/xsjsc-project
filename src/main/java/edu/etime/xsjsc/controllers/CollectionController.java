package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.dto.CollectionProduct;
import edu.etime.xsjsc.pojo.Collection;
import edu.etime.xsjsc.servcies.interfaces.CollectionService;
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
    @DeleteMapping("/collection/{id}")
    public Integer deleteCollection(@PathVariable("id") String id) {
        return collectionService.deleteCollectionById(id);
    }
    @PutMapping("/collection")
    public Integer addCollection(Collection collection) {
        collection.setId(UUID.randomUUID().toString());
        return collectionService.insertCollection(collection);
    }
}
