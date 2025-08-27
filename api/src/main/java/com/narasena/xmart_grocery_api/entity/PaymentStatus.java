package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

import java.util.UUID;

import com.narasena.xmart_grocery_api.enums.PaymentStatusType;

@Entity
@Table(name = "payment_statuses")
public class PaymentStatus extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "payment_id", nullable = false)
  private Payment payment;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentStatusType status;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public PaymentStatusType getStatus() {
    return status;
  }

  public void setStatus(PaymentStatusType status) {
    this.status = status;
  }
}
