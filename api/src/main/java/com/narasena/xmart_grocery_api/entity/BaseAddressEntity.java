package com.narasena.xmart_grocery_api.entity;

import java.util.UUID;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseAddressEntity extends BaseEntity {
    @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name="street_address", nullable = false)
  private String streetAddress;  // alamat

  @Column(name = "sub_district")
  private String subDistrict;    // kelurahan

  @Column
  private String district;       // kecamatan

  @Column(nullable = false)
  private String city;           // kabupaten/kota

  @Column(nullable = false)
  private String province;       // provinsi

  @Column(nullable = false)
  private String country;        // negara

  @Column(name = "postal_code")
  private String postalCode;     // kode pos

  @Column
  private String latitude;

  @Column
  private String longitude;

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

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

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }
  public void setProvince(String province) {
    this.province = province;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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
