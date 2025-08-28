package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@Data
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String sku;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<ProductImage> productImages;

    @ManyToOne
    @JoinColumn(name = "product_sub_category_id")
    private ProductSubCategory productSubCategory;

    @ManyToOne
    @JoinColumn(name = "product_brand_id")
    private ProductBrand productBrand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<ProductStock> productStocks;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<CartItem> cartItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<PromotionProduct> promotionProducts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<OrderItem> orderItems;

}
