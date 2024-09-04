package com.pereiravinao.coupon_processor.parameter;

import com.pereiravinao.coupon_processor.model.ProductModel;

import java.math.BigDecimal;

public class ProductParameter {
    private String name;
    private String ean;
    private BigDecimal unitaryPrice;
    private Integer quantity;


    public ProductParameter() {
    }

    public ProductModel toModel() {
        ProductModel productModel = new ProductModel();
        productModel.setName(this.name);
        productModel.setEan(this.ean);
        productModel.setUnitaryPrice(this.unitaryPrice);
        productModel.setQuantity(this.quantity);
        return productModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public BigDecimal getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(BigDecimal unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
