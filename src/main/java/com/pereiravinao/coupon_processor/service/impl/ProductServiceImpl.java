package com.pereiravinao.coupon_processor.service.impl;

import com.pereiravinao.coupon_processor.model.ProductMockResponse;
import com.pereiravinao.coupon_processor.service.ApiMockService;
import com.pereiravinao.coupon_processor.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ApiMockService apiMockService;

    public ProductServiceImpl(ApiMockService apiMockService) {
        this.apiMockService = apiMockService;
    }

    @Override
    public ProductMockResponse validateProduct(String ean) {
        return this.apiMockService.validateProductByEAN(ean);
    }
}
