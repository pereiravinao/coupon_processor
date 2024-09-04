package com.pereiravinao.coupon_processor.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CouponModel implements Serializable {

    private Long id;
    private String code44;
    private LocalDate purchaseDate;
    private BigDecimal totalValue;
    private String companyDocument;
    private String state;
    private List<ProductModel> products;
    private String buyerName;
    private LocalDate buyerBirthDate;
    private String buyerDocument;

    public CouponModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode44() {
        return code44;
    }

    public void setCode44(String code44) {
        this.code44 = code44;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getCompanyDocument() {
        return companyDocument;
    }

    public void setCompanyDocument(String companyDocument) {
        this.companyDocument = companyDocument;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public LocalDate getBuyerBirthDate() {
        return buyerBirthDate;
    }

    public void setBuyerBirthDate(LocalDate buyerBirthDate) {
        this.buyerBirthDate = buyerBirthDate;
    }

    public String getBuyerDocument() {
        return buyerDocument;
    }

    public void setBuyerDocument(String buyerDocument) {
        this.buyerDocument = buyerDocument;
    }
}
