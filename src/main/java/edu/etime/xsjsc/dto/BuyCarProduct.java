package edu.etime.xsjsc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)  //非空才会序列化
public class BuyCarProduct extends Buycar {
    private Product product;

    public BuyCarProduct(Buycar buycar) {
        this.setOpenid(buycar.getOpenid());
        this.setId(buycar.getId());
        this.setNum(buycar.getNum());
        this.setProductid(buycar.getProductid());
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
