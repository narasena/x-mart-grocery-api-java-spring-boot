package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import com.narasena.xmart_grocery_api.enums.VoucherStatus;

@Entity
@Table(name = "vouchers")
public class Voucher extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "voucher_code", nullable = false, unique = true)
    private String voucherCode;             // Unique code like "REF-ABC123"
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;                      // Owner of voucher
    
    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = false)
    private Promotion promotion;            // Source promotion
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VoucherStatus status = VoucherStatus.ISSUED;
    
    // Voucher-specific values (can override promotion defaults)
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;
    
    @Column(name = "minimum_purchase")
    private BigDecimal minimumPurchase;
    
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;
    
    @Column(name = "used_at")
    private LocalDateTime usedAt;
    
    @ManyToOne
    @JoinColumn(name = "used_in_order_id")
    private Order usedInOrder;              // Which order used this voucher
    
    // Source tracking
    @Column(name = "source_type")
    private String sourceType;              // "REFERRAL", "BIRTHDAY", "LOYALTY"
    
    @Column(name = "source_reference_id")
    private UUID sourceReferenceId;         // ID of referral, etc.
    
    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public String getVoucherCode() { return voucherCode; }
    public void setVoucherCode(String voucherCode) { this.voucherCode = voucherCode; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public Promotion getPromotion() { return promotion; }
    public void setPromotion(Promotion promotion) { this.promotion = promotion; }
    
    public VoucherStatus getStatus() { return status; }
    public void setStatus(VoucherStatus status) { this.status = status; }
    
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(BigDecimal discountAmount) { this.discountAmount = discountAmount; }
    
    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
    
    public LocalDateTime getUsedAt() { return usedAt; }
    public void setUsedAt(LocalDateTime usedAt) { this.usedAt = usedAt; }
    
    public Order getUsedInOrder() { return usedInOrder; }
    public void setUsedInOrder(Order usedInOrder) { this.usedInOrder = usedInOrder; }
    
    public String getSourceType() { return sourceType; }
    public void setSourceType(String sourceType) { this.sourceType = sourceType; }
}