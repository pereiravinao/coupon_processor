package com.pereiravinao.coupon_processor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "coupons")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code44", nullable = false, length = 44, unique = true)
    private String code44;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @Column(name = "company_document", nullable = false, length = 14)
    private String companyDocument;

    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductEntity> products;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "buyer_birth_date")
    private LocalDate buyerBirthDate;

    @Column(name = "buyer_document", length = 11)
    private String buyerDocument;

    public CouponEntity() {
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

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
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
