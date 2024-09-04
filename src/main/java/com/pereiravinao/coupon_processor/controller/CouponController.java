package com.pereiravinao.coupon_processor.controller;

import com.pereiravinao.coupon_processor.model.CouponModel;
import com.pereiravinao.coupon_processor.parameter.CreateCouponParameter;
import com.pereiravinao.coupon_processor.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createCoupon(@RequestBody CreateCouponParameter parameter) {
        try {
            CouponModel couponModel = parameter.toModel();
            couponService.createCoupon(couponModel);

            return new ResponseEntity<>("Cupom criado com sucesso!", HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>("Erro: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}