package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "stores")
public class Store extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false, unique = true)
  private String slug;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToOne
  @JoinColumn(name = "store_manager_id")
  private User storeManager;

  @Column
  private String storeImgUrl;

  @Column
  private String resourceId;

  @OneToOne
  @JoinColumn(name = "store_address_id")
  private Address storeAddress;

  @Column
  private String latitude;

  @Column
  private String longitude;

  @Column( unique = true)
  private String phoneNumber;

  @Column(unique = true)
  private String email;

  @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
  private java.util.List<Product> products;

  @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
  private java.util.List<Order> orders;

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  } 
  public String getStoreImgUrl() {
    return storeImgUrl;
  }

  public void setStoreImgUrl(String storeImgUrl) {
    this.storeImgUrl = storeImgUrl;
  }
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }
  public Address getStoreAddress() {
    return storeAddress;
  }

  public void setStoreAddress(Address storeAddress) {
    this.storeAddress = storeAddress;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public java.util.List<Product> getProducts() {
    return products;
  }

  public void setProducts(java.util.List<Product> products) {
    this.products = products;
  }

  public java.util.List<Order> getOrders() {
    return orders;
  }

  public void setOrders(java.util.List<Order> orders) {
    this.orders = orders;
  }
  
}
