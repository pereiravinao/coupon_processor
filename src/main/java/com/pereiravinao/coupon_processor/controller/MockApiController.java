package com.pereiravinao.coupon_processor.controller;

import com.pereiravinao.coupon_processor.model.ProductMockResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mock")
public class MockApiController {

    @GetMapping("/validateProduct/{ean}")
    public ProductMockResponse validateProduct(@PathVariable String ean) {
        if (ean.equals("4565156131")) {
            return new ProductMockResponse(ean,
                    "Sabão Líquido OMO Lavagem Perfeita 500ml", 5.00, 25.35);
        } else {
            return new ProductMockResponse(ean, "Produto Desconhecido", 0.00, 0.00);
        }
    }
}