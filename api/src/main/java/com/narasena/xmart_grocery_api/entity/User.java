package com.narasena.xmart_grocery_api.entity;

import java.util.UUID;
import com.narasena.xmart_grocery_api.enums.Gender;
import com.narasena.xmart_grocery_api.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(columnDefinition = "TEXT", nullable = false, unique = true)
  private String email;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String password;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private Boolean isVerified = false;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String firstName;

  @Column(columnDefinition = "TEXT")
  private String lastName;

  @Column(columnDefinition = "TEXT")
  private String dateOfBirth;

  @Enumerated(EnumType.STRING)
  @Column
  private Gender gender;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserRole role = UserRole.CUSTOMER;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private java.util.List<Address> userAddresses;  

  @Column(columnDefinition = "TEXT")
  private String userImgUrl;

  @Column(columnDefinition = "TEXT")
  private String resourceId;

  @Column(columnDefinition = "TEXT", name = "referral_code")
  private String referralCode;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private Cart cart;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private java.util.List<Order> orders;

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
  public Gender getGender() {
    return gender;
  }
  public void setGender(Gender gender) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public java.util.List<Address> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(java.util.List<Address> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public java.util.List<Order> getOrders() {
        return orders;
    }

    public void setOrders(java.util.List<Order> orders) {
        this.orders = orders;
    }
}
