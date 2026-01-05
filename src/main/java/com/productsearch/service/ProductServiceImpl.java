package com.productsearch.service;

import com.productsearch.dto.ProductResponse;
import com.productsearch.entity.Product;
import com.productsearch.entity.ProductStatus;
import com.productsearch.repository.ProductRepository;
import com.productsearch.spec.ProductSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Page<ProductResponse> search(
            String q,
            Long brandID,
            Long categoryID,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Boolean inStock,
            BigDecimal minRating,
            BigDecimal maxRating,
            ProductStatus status,
            Pageable pageable)
    {

        Specification<Product> spec = Specification
                .where(ProductSpecifications.nameContains(q))
                .and(ProductSpecifications.hasBrandId(brandID))
                .and(ProductSpecifications.hasCategoryId(categoryID))
                .and(ProductSpecifications.priceGte(minPrice))
                .and(ProductSpecifications.priceLte(maxPrice))
                .and(ProductSpecifications.inStock(inStock))
                .and(ProductSpecifications.ratingGte(minRating))
                .and(ProductSpecifications.ratingLte(maxRating))
                .and(ProductSpecifications.hasStatus(status));

        return productRepository.findAll(spec, pageable)
                .map(this::toResponse);
    }

    private ProductResponse toResponse(Product p) {
        return ProductResponse.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .stock(p.getStock())
                .rating(p.getRating())
                .status(p.getStatus().name())
                .brandId(p.getBrand().getId())
                .brandName(p.getBrand().getName())
                .categoryId(p.getCategory().getId())
                .categoryName(p.getCategory().getName())
                .build();
    }
}
