package com.productsearch.controller;


import com.productsearch.dto.ProductResponse;
import com.productsearch.entity.ProductStatus;
import com.productsearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/search")
    public Page<ProductResponse> search(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(required = false) BigDecimal minRating,
            @RequestParam(required = false) BigDecimal maxRating,
            @RequestParam(required = false) ProductStatus status,
            Pageable pageable
    )
    {
        return productService.search(q, brandId, categoryId,
                minPrice, maxPrice,
                inStock,
                minRating, maxRating,
                status,
                pageable);

    }
}
