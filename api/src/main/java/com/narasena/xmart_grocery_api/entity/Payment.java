package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

import com.narasena.xmart_grocery_api.enums.PaymentMethod;

@Entity
@Table(name = "payments")
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

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
  
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public PaymentMethod getMethod() {
    return method;
  }

  public void setMethod(PaymentMethod method) {
    this.method = method;
  }

  public boolean isSuccessful() {
    return isSuccessful;
  }
  public void setSuccessful(boolean successful) {
    isSuccessful = successful;
  }

  public java.util.List<PaymentStatus> getPaymentStatuses() {
    return paymentStatuses;
  }
  public void setPaymentStatuses(java.util.List<PaymentStatus> paymentStatuses) {
    this.paymentStatuses = paymentStatuses;
  }
  
}
