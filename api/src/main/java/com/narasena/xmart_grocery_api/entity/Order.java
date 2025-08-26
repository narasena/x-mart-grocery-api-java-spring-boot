package com.narasena.xmart_grocery_api.entity;
import jakarta.persistence.*;
import java.util.UUID;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;

  @ManyToOne
  @JoinColumn(name = "store_id", nullable = false)
  private Store store;

  @ManyToOne(optional = false)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private java.util.List<OrderItem> orderItems;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private java.util.List<OrderStatus> orderStatuses;

  @Column(name = "total_amount", nullable = false)
  private BigDecimal totalAmount;

  @Column(name = "discount_amount")
  private BigDecimal discountAmount;
  
  @Column(name = "shipping_cost", nullable = false)
  private BigDecimal shippingCost;

  @Column(name = "final_amount", nullable = false)
  private BigDecimal finalAmount;

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public java.util.List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(java.util.List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }
  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }

  public java.util.List<OrderStatus> getOrderStatuses() {
    return orderStatuses;
  }
  public void setOrderStatuses(java.util.List<OrderStatus> orderStatuses) {
    this.orderStatuses = orderStatuses;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BigDecimal getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(BigDecimal discountAmount) {
    this.discountAmount = discountAmount;
  }

  public BigDecimal getShippingCost() {
    return shippingCost;
  }

  public void setShippingCost(BigDecimal shippingCost) {
    this.shippingCost = shippingCost;
  }

  public BigDecimal getFinalAmount() {
    return finalAmount;
  }

  public void setFinalAmount(BigDecimal finalAmount) {
    this.finalAmount = finalAmount;
  }


}
