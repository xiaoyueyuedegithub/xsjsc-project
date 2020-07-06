package edu.etime.xsjsc.dto;

import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Product;

public class OrderProduct extends Orders {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
