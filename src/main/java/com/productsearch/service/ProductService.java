package com.productsearch.service;


import com.productsearch.dto.ProductResponse;
import com.productsearch.entity.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface ProductService {

    Page<ProductResponse> search(
      String q,
      Long brandID,
      Long categoryID,
      BigDecimal minPrice,
      BigDecimal maxPrice,
      Boolean inStock,
      BigDecimal minRating,
      BigDecimal maxRating,
      ProductStatus status,
      Pageable pageable
    );
}
