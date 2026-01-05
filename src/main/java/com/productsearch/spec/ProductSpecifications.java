package com.productsearch.spec;

import com.productsearch.entity.Product;
import com.productsearch.entity.ProductStatus;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecifications {

    private ProductSpecifications() {
    }

    public static Specification<Product> nameContains(String q) {
        return (root, query, cb) -> {
            if (q == null || q.isBlank()) return null;
            return cb.like(cb.lower(root.get("name")), "%" + q.toLowerCase() + "%");
        };
    }

    public static Specification<Product> hasBrandId(Long brandId) {
        return (root, query, cb) -> {
            if (brandId == null) return null;
            return cb.equal(root.get("brand").get("id"), brandId);
        };
    }

    public static Specification<Product> hasCategoryId(Long categoryId) {
        return (root, query, cb) -> {
            if (categoryId == null) return null;
            return cb.equal(root.get("category").get("id"), categoryId);
        };
    }


    public static Specification<Product> priceGte(BigDecimal minPrice) {

        return (root, query, cb) -> {
            if (minPrice == null) return null;
            return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
        };
    }

    public static Specification<Product> ratingLte(BigDecimal maxRating) {
        return (root, query, cb) -> {
            if (maxRating == null) return null;
            return cb.lessThanOrEqualTo(root.get("rating"), maxRating);
        };
    }

    public static Specification<Product> priceLte(BigDecimal maxPrice) {
        return (root, query, cb) -> {
            if (maxPrice == null) return null;
            return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
        };
    }

    public static Specification<Product> ratingGte(BigDecimal minRating) {
        return (root, query, cb) -> {
            if (minRating == null) return null;
            return cb.greaterThanOrEqualTo(root.get("rating"), minRating);
        };
    }

    public static Specification<Product> inStock(Boolean inStock) {
        return (root, query, cb) -> {
            if (inStock == null) return null;
            if (inStock) return cb.greaterThan(root.get("stock"), 0);
            return cb.equal(root.get("stock"), 0);
        };
    }

    public static Specification<Product> hasStatus(ProductStatus status) {
        return (root, query, cb) -> {
            if (status == null) return null;
            return cb.equal(root.get("status"), status);
        };
    }



}