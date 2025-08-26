package com.narasena.xmart_grocery_api.entity;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private Boolean isVerified = false;

  @Column(nullable = false)
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String dateOfBirth;

  @Column
  private String gender;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private java.util.List<UserAddress> userAddresses;  

  @Column
  private String userImgUrl;

  @Column
  private String resourceId;

  // Getters and setters
  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public Boolean getIsVerified() {
    return isVerified;
  }
  public void setIsVerified(Boolean isVerified) {
    this.isVerified = isVerified;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getDateOfBirth() {
    return dateOfBirth;
  }
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getUserImgUrl() {
    return userImgUrl;
  }
  public void setUserImgUrl(String userImgUrl) {
    this.userImgUrl = userImgUrl;
  }
  public String getResourceId() {
    return resourceId;
  }
  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

}
