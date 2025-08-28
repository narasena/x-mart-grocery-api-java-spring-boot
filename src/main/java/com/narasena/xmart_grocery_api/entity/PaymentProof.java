package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "payment_proof")
@Data
public class PaymentProof extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(columnDefinition = "TEXT", name = "payment_proof_img_url", nullable = false)
    private String paymentProofImgUrl;

    @Column(columnDefinition = "TEXT", name = "resouce_id", nullable = false)
    private String resourceId;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;

    @ManyToOne
    @JoinColumn(name = "verified_by", nullable = false)
    private User verifiedBy;

    @Column(name = "verified_at", nullable = false)
    private LocalDateTime verifiedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

}