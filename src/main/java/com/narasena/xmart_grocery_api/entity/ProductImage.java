package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_images")
@Data
public class ProductImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(columnDefinition = "TEXT", name = "img_url")
    private String imgUrl;

    @Column(columnDefinition = "TEXT")
    private String resourceId; // Provider-specific ID for deletion

    @Column
    private Boolean isMainImg = false;

}