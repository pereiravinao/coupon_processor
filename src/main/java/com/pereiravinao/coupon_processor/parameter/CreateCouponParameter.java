package com.pereiravinao.coupon_processor.parameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pereiravinao.coupon_processor.model.CouponModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CreateCouponParameter {
    private String code44;
    private LocalDate purchaseDate;
    private BigDecimal totalValue;
    private String companyDocument;

    @JsonProperty("State")
    private String state;
    private List<ProductParameter> products;

    public CreateCouponParameter() {
    }

    public CouponModel toModel() {
        CouponModel couponModel = new CouponModel();
        couponModel.setCode44(this.code44);
        couponModel.setPurchaseDate(this.purchaseDate);
        couponModel.setTotalValue(this.totalValue);
        couponModel.setCompanyDocument(this.companyDocument);
        couponModel.setState(this.state);

        if (this.products == null) {
            throw new IllegalArgumentException("A lista de produtos não pode ser nula.");
        }
        couponModel.setProducts(this.products.stream().map(ProductParameter::toModel).collect(Collectors.toList()));

        return couponModel;
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

    public List<ProductParameter> getProducts() {
        return products;
    }

    public void setProducts(List<ProductParameter> products) {
        this.products = products;
    }
}
