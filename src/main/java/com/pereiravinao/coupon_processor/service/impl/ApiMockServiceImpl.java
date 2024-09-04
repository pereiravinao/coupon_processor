package com.pereiravinao.coupon_processor.service.impl;

import com.pereiravinao.coupon_processor.model.ProductMockResponse;
import com.pereiravinao.coupon_processor.service.ApiMockService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiMockServiceImpl  implements ApiMockService {

    private final RestTemplate restTemplate;

    public ApiMockServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductMockResponse validateProductByEAN(String ean) {
        String url = "http://localhost:8080/api/mock/validateProduct/".concat(ean);
        return this.restTemplate.getForObject(url, ProductMockResponse.class);
    }

}
