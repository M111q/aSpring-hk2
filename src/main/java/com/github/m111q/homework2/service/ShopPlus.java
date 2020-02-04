package com.github.m111q.homework2.service;

import com.github.m111q.homework2.api.Shop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("plus")
public class ShopPlus extends ShopStart implements Shop {

    private final String NAME = "Shop Plus";

    @Value("${info.vat}")
    private Integer vat;

    public ShopPlus(ProductService productService) {
        super(productService);
    }

    @Override
    public BigDecimal calculatePrice() {
        BigDecimal basicPrice = super.calculatePrice();
        BigDecimal result = calculatePriceWithVat(basicPrice);
        return ProductService.roundPrice(result);
    }

    @Override
    public String toString() {
        return "ShopPlus{" +
                "NAME='" + NAME + '\'' +
                ", vat=" + vat +
                '}';
    }

    private BigDecimal calculatePriceWithVat(BigDecimal price) {
        BigDecimal vatPercent = BigDecimal.valueOf(this.vat + 100).divide(new BigDecimal(100));
        BigDecimal result = price.multiply(vatPercent);
        return result;
    }
}
