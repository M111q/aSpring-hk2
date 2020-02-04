package com.github.m111q.homework2.service;

import com.github.m111q.homework2.api.Shop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("pro")
public class ShopPro extends ShopPlus implements Shop {

    private final String NAME = "Shop Pro";

    public ShopPro(ProductService productService) {
        super(productService);
    }

    @Value("${info.discount}")
    private Integer discount;

    @Override
    public BigDecimal calculatePrice() {
        BigDecimal basicPriceWithVat = super.calculatePrice();
        return calculatePriceWithDiscount(basicPriceWithVat);
    }

    @Override
    public String toString() {
        return "ShopPro{" +
                "NAME='" + NAME + '\'' +
                ", discount=" + discount +
                '}';
    }

    private BigDecimal calculatePriceWithDiscount(BigDecimal price) {
        BigDecimal vatPercent = BigDecimal.valueOf(this.discount).divide(new BigDecimal(100));
        BigDecimal result = price.multiply(vatPercent);
        return ProductService.roundPrice(result);
    }
}
