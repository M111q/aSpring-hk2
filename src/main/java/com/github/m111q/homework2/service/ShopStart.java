package com.github.m111q.homework2.service;

import com.github.m111q.homework2.api.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("start")
public class ShopStart extends ShopImpl implements Shop {

    private ProductService productService;
    private final String NAME = "Shop Standard";

    @Autowired
    public ShopStart(ProductService productService) {
        super(productService);
    }

    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice();
    }

    @Override
    public String toString() {
        return "ShopStart{" +
                "NAME='" + NAME + '\'' +
                '}';
    }
}
