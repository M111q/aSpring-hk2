package com.github.m111q.homework2.api;

import com.github.m111q.homework2.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface Shop {
    BigDecimal calculatePrice();

    List<Product> getProductsList();
}
