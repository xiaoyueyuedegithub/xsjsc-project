package edu.etime.xsjsc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.etime.xsjsc.pojo.Collection;
import edu.etime.xsjsc.pojo.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)  //非空才会序列化
public class CollectionProduct extends Collection {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
