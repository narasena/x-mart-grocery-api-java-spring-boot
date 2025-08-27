package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import java.util.UUID;
import com.narasena.xmart_grocery_api.enums.AddressType;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AddressType type;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store store;

  @Column(nullable = false)
  private String name;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "is_main_address", nullable = false)
  private Boolean isMainAddress = false;

  @Column(name = "street_address", nullable = false)
  private String streetAddress;

  @Column(name = "sub_district")
  private String subDistrict;

  @Column
  private String district;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String province;

  @Column(nullable = false)
  private String country;

  @Column(name = "postal_code")
  private String postalCode;

  @Column
  private String latitude;

  @Column
  private String longitude;

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

  // Getters and setters for new fields
  public UUID getId() { return id; }
  public void setId(UUID id) { this.id = id; }
  
  public AddressType getType() { return type; }
  public void setType(AddressType type) { this.type = type; }
  
  public Store getStore() { return store; }
  public void setStore(Store store) { this.store = store; }
  
  public String getStreetAddress() { return streetAddress; }
  public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
  
  public String getCity() { return city; }
  public void setCity(String city) { this.city = city; }
  
  public String getProvince() { return province; }
  public void setProvince(String province) { this.province = province; }
  
  public String getCountry() { return country; }
  public void setCountry(String country) { this.country = country; }

  public String getSubDistrict() {
    return subDistrict;
  }

  public void setSubDistrict(String subDistrict) {
    this.subDistrict = subDistrict;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
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
}
