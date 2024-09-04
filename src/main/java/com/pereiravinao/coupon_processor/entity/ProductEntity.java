package com.pereiravinao.coupon_processor.entity;


import com.pereiravinao.coupon_processor.model.ProductModel;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ean", nullable = false, length = 13)
    private String ean;

    @Column(name = "unitary_price", nullable = false)
    private BigDecimal unitaryPrice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private CouponEntity coupon;

    public ProductEntity() {
    }

    public ProductEntity(ProductModel model) {
        if (model != null) {
            this.name = model.getName();
            this.ean = model.getEan();
            this.unitaryPrice = model.getUnitaryPrice();
            this.quantity = model.getQuantity();
        }
    }

    public ProductModel toModel() {
        ProductModel model = new ProductModel();
        model.setName(this.name);
        model.setEan(this.ean);
        model.setUnitaryPrice(this.unitaryPrice);
        model.setQuantity(this.quantity);
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CouponEntity getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponEntity coupon) {
        this.coupon = coupon;
    }
}
