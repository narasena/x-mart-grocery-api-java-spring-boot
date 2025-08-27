package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_brands")
@Data
public class ProductBrand extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "productBrand", cascade = CascadeType.ALL)
    private java.util.List<Product> products;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", name = "img_url")
    private String brandImgUrl;  // Generic URL - works with any CDN

    @Column(columnDefinition = "TEXT", name = "resource_id")
    private String resourceId; // Provider-specific ID for deletion

}