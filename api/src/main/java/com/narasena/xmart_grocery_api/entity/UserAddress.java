package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_addresses")
public class UserAddress extends BaseAddressEntity {

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(nullable = false)
  private String name;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "is_main_address", nullable = false)
  private Boolean isMainAddress = false; // Java-level default

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Boolean getIsMainAddress() {
    return isMainAddress;
  }

  public void setIsMainAddress(Boolean isMainAddress) {
    this.isMainAddress = isMainAddress;
  }
}
