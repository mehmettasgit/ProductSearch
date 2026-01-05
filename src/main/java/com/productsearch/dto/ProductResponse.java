package com.productsearch.dto;


import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class ProductResponse {

    Long id;
    String name;
    BigDecimal price;
    Integer stock;
    BigDecimal rating;
    String status;

    Long brandId;
    String brandName;

    Long categoryId;
    String categoryName;
}
