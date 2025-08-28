package com.narasena.xmart_grocery_api.entity;

import com.narasena.xmart_grocery_api.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "payments")
@Data
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod method;


    @Column(name = "is_successful", nullable = false)
    private boolean isSuccessful = false;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private java.util.List<PaymentStatus> paymentStatuses;

}