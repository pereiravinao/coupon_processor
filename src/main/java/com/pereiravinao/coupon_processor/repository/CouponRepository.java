package com.pereiravinao.coupon_processor.repository;

import com.pereiravinao.coupon_processor.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {

}
