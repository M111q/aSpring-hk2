package com.github.m111q.homework2.service;

import com.github.m111q.homework2.api.Shop;
import com.github.m111q.homework2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile("start")
@Component
public class ShopStart extends ShopImpl implements Shop {

    private ProductService productService;
    private final String NAME = "Shop Standard";

    public ShopStart(ProductService productService) {
        super(productService);
    }

    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice();
    }

    @Override
    public String toString() {
        return "ShopImpl{" +
                "NAME='" + NAME + '\'' +
                '}';
    }
}
