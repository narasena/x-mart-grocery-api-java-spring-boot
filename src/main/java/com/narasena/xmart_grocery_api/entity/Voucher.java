package com.narasena.xmart_grocery_api.entity;

import com.narasena.xmart_grocery_api.enums.VoucherStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vouchers")
@Data
public class Voucher extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT", name = "voucher_code", nullable = false, unique = true)
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
    @Column(columnDefinition = "TEXT", name = "source_type")
    private String sourceType;              // "REFERRAL", "BIRTHDAY", "LOYALTY"

    @Column(name = "source_reference_id")
    private UUID sourceReferenceId;         // ID of referral, etc.

}
