package com.pereiravinao.coupon_processor.service.impl;

import com.pereiravinao.coupon_processor.entity.CouponEntity;
import com.pereiravinao.coupon_processor.model.CouponModel;
import com.pereiravinao.coupon_processor.repository.CouponRepository;
import com.pereiravinao.coupon_processor.service.CouponService;
import com.pereiravinao.coupon_processor.service.RabbitMQService;
import com.pereiravinao.coupon_processor.validator.CouponValidator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponValidator couponValidator;
    private final CouponRepository couponRepository;
    private final RabbitMQService rabbitMQService;

    public CouponServiceImpl(CouponValidator couponValidator, CouponRepository couponRepository, RabbitMQService rabbitMQService) {
        this.couponValidator = couponValidator;
        this.couponRepository = couponRepository;
        this.rabbitMQService = rabbitMQService;
    }

    @Override
    @Transactional
    public void createCoupon(CouponModel couponModel) {
        couponValidator.validateCoupon(couponModel);
        CouponEntity couponEntity = new CouponEntity(couponModel);
        couponEntity = couponRepository.save(couponEntity);
        rabbitMQService.publishMessage("coupon.queue", couponEntity.toModel());
    }

    @Override
    @Transactional
    public void processMessage(CouponModel coupon) {
        if (coupon == null)  return;

        couponRepository.save(new CouponEntity(coupon));
    }
}
