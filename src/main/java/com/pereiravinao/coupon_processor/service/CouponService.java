package com.pereiravinao.coupon_processor.service;

import com.pereiravinao.coupon_processor.model.CouponModel;

public interface CouponService {

    void createCoupon(CouponModel couponModel);

    void processMessage(CouponModel coupon);
}
