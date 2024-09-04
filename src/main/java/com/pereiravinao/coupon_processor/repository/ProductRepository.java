package com.pereiravinao.coupon_processor.repository;

import com.pereiravinao.coupon_processor.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {
}
