package com.pereiravinao.coupon_processor.listener;

import com.pereiravinao.coupon_processor.model.CouponModel;
import com.pereiravinao.coupon_processor.service.CouponService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RabbitMQListener {

    private final CouponService couponService;

    public RabbitMQListener(CouponService couponService) {
        this.couponService = couponService;
    }

    @RabbitListener(queues = "coupon.queue")
    public void handleMessage(CouponModel coupon) {
        if (coupon == null) {
            return;
        }

        coupon.setBuyerName("Lucas Souza");
        coupon.setBuyerBirthDate(LocalDate.parse("1994-03-29"));
        coupon.setBuyerDocument("419.438.578.98".replace(".", "").replace("-", ""));
        couponService.processMessage(coupon);
    }
}
