package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stores")
@Data
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "store_manager_id")
    private User storeManager;

    @Column(columnDefinition = "TEXT")
    private String storeImgUrl;

    @Column(columnDefinition = "TEXT")
    private String resourceId;

    @OneToOne
    @JoinColumn(name = "store_address_id")
    private Address storeAddress;

    @Column(columnDefinition = "TEXT")
    private String latitude;

    @Column(columnDefinition = "TEXT")
    private String longitude;

    @Column(columnDefinition = "TEXT", unique = true)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT", unique = true)
    private String email;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private java.util.List<ProductStock> productStocks;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private java.util.List<Order> orders;

}