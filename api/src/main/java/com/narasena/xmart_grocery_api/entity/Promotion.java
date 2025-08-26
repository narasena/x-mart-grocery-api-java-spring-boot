package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import com.narasena.xmart_grocery_api.enums.PromotionType;
import com.narasena.xmart_grocery_api.enums.PromotionStatus;

@Entity
@Table(name = "promotions")
public class Promotion extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false)
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
    @Column(name = "promo_code", unique = true)
    private String promoCode;               // Optional coupon code
    
   @OneToMany(mappedBy = "promotion")
   private java.util.List<PromotionProduct> applicableProducts;
    
   @OneToMany(mappedBy = "promotion")
   private java.util.List<PromotionStore> applicableStores;

    
    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public PromotionType getType() { return type; }
    public void setType(PromotionType type) { this.type = type; }
    
    public PromotionStatus getStatus() { return status; }
    public void setStatus(PromotionStatus status) { this.status = status; }
    
    public BigDecimal getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(BigDecimal discountPercentage) { this.discountPercentage = discountPercentage; }
    
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(BigDecimal discountAmount) { this.discountAmount = discountAmount; }
    
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    
    public String getPromoCode() { return promoCode; }
    public void setPromoCode(String promoCode) { this.promoCode = promoCode; }
    
    public java.util.List<PromotionProduct> getApplicableProducts() { return applicableProducts; }
    public void setApplicableProducts(java.util.List<PromotionProduct> applicableProducts) { this.applicableProducts = applicableProducts; }
    
    public java.util.List<PromotionStore> getApplicableStores() { return applicableStores; }
    public void setApplicableStores(java.util.List<PromotionStore> applicableStores) { this.applicableStores = applicableStores; }
}
