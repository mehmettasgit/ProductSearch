package com.productsearch.config;

import com.productsearch.entity.Brand;
import com.productsearch.entity.Category;
import com.productsearch.entity.Product;
import com.productsearch.entity.ProductStatus;
import com.productsearch.repository.BrandRepository;
import com.productsearch.repository.CategoryRepository;
import com.productsearch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        Brand apple = brandRepository.save(Brand.builder().name("Apple").build());
        Brand samsung = brandRepository.save(Brand.builder().name("Samsung").build());
        Brand xiaomi = brandRepository.save(Brand.builder().name("Xiaomi").build());

        Category phone = categoryRepository.save(Category.builder().name("Phone").build());
        Category laptop = categoryRepository.save(Category.builder().name("Laptop").build());
        Category accessories = categoryRepository.save(Category.builder().name("Accessories").build());

        productRepository.saveAll(List.of(
                Product.builder().name("iPhone 15").price(new BigDecimal("65000")).stock(12).rating(new BigDecimal("4.7"))
                        .status(ProductStatus.ACTIVE).brand(apple).category(phone).build(),
                Product.builder().name("iPhone Case").price(new BigDecimal("899")).stock(0).rating(new BigDecimal("4.1"))
                        .status(ProductStatus.ACTIVE).brand(apple).category(accessories).build(),
                Product.builder().name("Galaxy S24").price(new BigDecimal("52000")).stock(8).rating(new BigDecimal("4.5"))
                        .status(ProductStatus.ACTIVE).brand(samsung).category(phone).build(),
                Product.builder().name("Xiaomi Redmi Note").price(new BigDecimal("14000")).stock(25).rating(new BigDecimal("4.2"))
                        .status(ProductStatus.ACTIVE).brand(xiaomi).category(phone).build(),
                Product.builder().name("MacBook Air").price(new BigDecimal("82000")).stock(3).rating(new BigDecimal("4.8"))
                        .status(ProductStatus.ACTIVE).brand(apple).category(laptop).build(),
                Product.builder().name("Old Model Laptop").price(new BigDecimal("20000")).stock(0).rating(new BigDecimal("3.9"))
                        .status(ProductStatus.PASSIVE).brand(samsung).category(laptop).build()
        ));
    }
}
