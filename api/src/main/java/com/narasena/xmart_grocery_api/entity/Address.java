package com.narasena.xmart_grocery_api.entity;

import com.narasena.xmart_grocery_api.enums.AddressType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "addresses")
@Data
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AddressType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT", name = "is_main_address", nullable = false)
    private Boolean isMainAddress = false;

    @Column(columnDefinition = "TEXT", name = "street_address", nullable = false)
    private String streetAddress;

    @Column(columnDefinition = "TEXT", name = "sub_district")
    private String subDistrict;

    @Column(columnDefinition = "TEXT")
    private String district;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String city;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String province;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String country;

    @Column(columnDefinition = "TEXT", name = "postal_code")
    private String postalCode;

    @Column(columnDefinition = "TEXT")
    private String latitude;

    @Column(columnDefinition = "TEXT")
    private String longitude;

}