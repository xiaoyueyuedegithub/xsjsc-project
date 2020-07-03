package edu.etime.xsjsc.dto;

import edu.etime.xsjsc.pojo.Collection;
import edu.etime.xsjsc.pojo.Product;

public class CollectionProduct extends Collection {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
