package com.github.m111q.homework2.service;

import com.github.m111q.homework2.api.Shop;
import com.github.m111q.homework2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public abstract class ShopImpl implements Shop {

    private ProductService productService;

    @Autowired
    public ShopImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public BigDecimal calculatePrice() {
        BigDecimal result = BigDecimal.valueOf(0);

        for (Product e : productService.getProductList()) {
            result = result.add(e.getPrice());
        }
        return ProductService.roundPrice(result);
    }

    @Override
    public List<Product> getProductsList() {
        return productService.getProductList();
    }
}
