package com.pereiravinao.coupon_processor.service;

import com.pereiravinao.coupon_processor.model.ProductMockResponse;

public interface ApiMockService {

    ProductMockResponse validateProductByEAN(String ean);

}
