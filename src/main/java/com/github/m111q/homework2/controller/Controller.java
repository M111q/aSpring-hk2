package com.github.m111q.homework2.controller;

import com.github.m111q.homework2.api.Shop;
import com.github.m111q.homework2.model.Product;
import com.github.m111q.homework2.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class Controller {

    private Shop shop;
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    public Controller(Shop shop) {
        this.shop = shop;
        logger.info("sum = " + shop.calculatePrice() + " " + shop.toString());
    }

    @GetMapping
    public BigDecimal getProductsSum() {
        return shop.calculatePrice();
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return shop.getProductsList();
    }
}
