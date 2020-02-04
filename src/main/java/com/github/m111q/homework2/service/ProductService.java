package com.github.m111q.homework2.service;

import com.github.m111q.homework2.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {
    private final Integer MAX_PRICE = 300;
    private final Integer MIN_PRICE = 50;
    private final Integer STARTING_QUANTITY_OF_PRODUCTS = 5;
    private final Integer PRODUCT_NAME_LENGTH = 5;
    private Logger logger = LoggerFactory.getLogger(ProductService.class);
    private List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();
        generateProducts();
        showProducts();
        logger.info("sum = " + calculatePrice());
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void showProducts() {
        productList.forEach(e -> System.out.println(e));
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public BigDecimal calculatePrice() {
        BigDecimal result = BigDecimal.valueOf(0);

        for (Product e : productList) {
            result = result.add(e.getPrice());
        }
        return result;
    }

    private void generateProducts() {
        for (int i = 0; i < STARTING_QUANTITY_OF_PRODUCTS; i++) {
            addProduct(new Product(generateRandomProductName(), generatePriceInRange()));
        }
    }

    private BigDecimal generatePriceInRange() {
        Random r = new Random();
        BigDecimal result = BigDecimal.valueOf(MIN_PRICE + (MAX_PRICE - MIN_PRICE) * r.nextDouble());
        return roundPrice(result);
    }

    public static BigDecimal roundPrice(BigDecimal result) {
        return result.setScale(2, RoundingMode.HALF_DOWN);
    }

    private String generateRandomProductName() {
        char a = 'a';
        char z = 'z';
        int leftLimit = a;
        int rightLimit = z;

        Random r = new Random();

        return r.ints(leftLimit, rightLimit + 1)
                .limit(PRODUCT_NAME_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
