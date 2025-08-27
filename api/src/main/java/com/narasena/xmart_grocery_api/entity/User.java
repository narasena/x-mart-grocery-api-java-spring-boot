package com.narasena.xmart_grocery_api.entity;

import com.narasena.xmart_grocery_api.enums.Gender;
import com.narasena.xmart_grocery_api.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String password;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Boolean isVerified = false;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String firstName;

    @Column(columnDefinition = "TEXT")
    private String lastName;

    @Column(columnDefinition = "TEXT")
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.CUSTOMER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private java.util.List<Address> userAddresses;

    @Column(columnDefinition = "TEXT")
    private String userImgUrl;

    @Column(columnDefinition = "TEXT")
    private String resourceId;

    @Column(columnDefinition = "TEXT", name = "referral_code")
    private String referralCode;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private java.util.List<Order> orders;

}