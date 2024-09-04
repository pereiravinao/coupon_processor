package com.pereiravinao.coupon_processor.validator;


import com.pereiravinao.coupon_processor.model.CouponModel;
import com.pereiravinao.coupon_processor.model.ProductMockResponse;
import com.pereiravinao.coupon_processor.model.ProductModel;
import com.pereiravinao.coupon_processor.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Pattern;

@Component
public class CouponValidator {

    private final ProductService productService;

    public CouponValidator(ProductService productService) {
        this.productService = productService;
    }


    public void validateCoupon(CouponModel coupon) {
        validateCode44(coupon.getCode44());
        validateCompanyDocument(coupon.getCompanyDocument());
        validateTotalValue(coupon);
        validateProducts(coupon.getProducts());
    }


    private void validateCode44(String code44) {
        if (code44 == null || code44.length() != 44 || !Pattern.matches("\\d{44}", code44)) {
            throw new IllegalArgumentException("O code44 deve conter exatamente 44 caracteres numéricos.");
        }
    }

    private void validateCompanyDocument(String companyDocument) {
        if (!isValidCNPJ(companyDocument)) {
            throw new IllegalArgumentException("O CNPJ informado é inválido.");
        }
    }

    private void validateTotalValue(CouponModel coupon) {
        BigDecimal sum = coupon.getProducts().stream()
                .map(product -> product.getUnitaryPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (coupon.getTotalValue().compareTo(sum) != 0) {
            throw new IllegalArgumentException("O valor total do cupom não corresponde à soma dos produtos.");
        }
    }

    private void validateProducts(Iterable<ProductModel> products) {
        for (ProductModel product : products) {
            ProductMockResponse response = productService.validateProduct(product.getEan());
            if (product.getUnitaryPrice().compareTo(BigDecimal.valueOf(response.getMinPrice())) < 0 ||
                    product.getUnitaryPrice().compareTo(BigDecimal.valueOf(response.getMaxPrice())) > 0) {
                throw new IllegalArgumentException("O preço do produto " + product.getName() + " está fora da faixa permitida.");
            }
        }
    }

    private Boolean isValidCNPJ(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || !cnpj.matches("\\d+")) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}