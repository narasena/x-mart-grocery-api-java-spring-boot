package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_stocks")
@Data
public class ProductStock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Many-to-One: Many stocks belong to one product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Many-to-One: Many stocks belong to one store
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "min_stock_level", nullable = false)
    private Integer minStockLevel;

}