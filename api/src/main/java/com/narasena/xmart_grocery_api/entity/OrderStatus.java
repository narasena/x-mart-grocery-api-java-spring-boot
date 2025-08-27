package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

import java.util.UUID;

import com.narasena.xmart_grocery_api.enums.OrderStatusType;


@Entity
@Table(name = "order_status")
public class OrderStatus extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @Enumerated(EnumType.STRING)
  private OrderStatusType status;
  
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

  public OrderStatusType getStatus() {
    return status;
  }

  public void setStatus(OrderStatusType status) {
    this.status = status;
  }
}
