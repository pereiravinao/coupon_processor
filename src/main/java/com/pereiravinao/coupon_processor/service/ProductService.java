package com.pereiravinao.coupon_processor.service;

import com.pereiravinao.coupon_processor.model.ProductMockResponse;

public interface ProductService {

    ProductMockResponse validateProduct(String ean);

}
