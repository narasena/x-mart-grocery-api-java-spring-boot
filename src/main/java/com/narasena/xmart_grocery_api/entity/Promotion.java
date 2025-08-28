package com.narasena.xmart_grocery_api.entity;

import com.narasena.xmart_grocery_api.enums.PromotionStatus;
import com.narasena.xmart_grocery_api.enums.PromotionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "promotions")
@Data
public class Promotion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PromotionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PromotionStatus status = PromotionStatus.DRAFT;

    // Discount values
    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;  // For PERCENTAGE_OFF

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;      // For FIXED_AMOUNT_OFF

    @Column(name = "minimum_purchase")
    private BigDecimal minimumPurchase;     // Minimum order value

    @Column(name = "maximum_discount")
    private BigDecimal maximumDiscount;     // Cap on discount amount

    // Buy X Get Y fields
    @Column(name = "buy_quantity")
    private Integer buyQuantity;            // Buy X

    @Column(name = "get_quantity")
    private Integer getQuantity;            // Get Y

    // Time constraints
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    // Usage limits
    @Column(name = "usage_limit")
    private Integer usageLimit;             // Total uses allowed

    @Column(name = "usage_count")
    private Integer usageCount = 0;         // Current usage

    @Column(name = "per_user_limit")
    private Integer perUserLimit;           // Uses per customer

    // Promo code
    @Column(columnDefinition = "TEXT", name = "promo_code", unique = true)
    private String promoCode;               // Optional coupon code

    @OneToMany(mappedBy = "promotion")
    private java.util.List<PromotionProduct> applicableProducts;

    @OneToMany(mappedBy = "promotion")
    private java.util.List<PromotionStore> applicableStores;

}