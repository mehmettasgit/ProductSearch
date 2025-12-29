package com.productsearch.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products",
        indexes = {
                @Index(name = "idx_products_name", columnList = "name"),
                @Index(name = "idx_products_price", columnList = "price"),
                @Index(name = "idx_products_rating", columnList = "rating")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProductStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
