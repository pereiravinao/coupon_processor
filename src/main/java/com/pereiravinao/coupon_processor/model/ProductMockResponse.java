package com.pereiravinao.coupon_processor.model;

import java.io.Serializable;

public class ProductMockResponse implements Serializable {
    private String ean;
    private String productName;
    private double minPrice;
    private double maxPrice;

    public ProductMockResponse() {
    }

    public ProductMockResponse(String ean, String productName, double minPrice, double maxPrice) {
        this.ean = ean;
        this.productName = productName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
