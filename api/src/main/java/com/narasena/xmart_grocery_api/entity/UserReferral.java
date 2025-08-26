package com.narasena.xmart_grocery_api.entity;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "user_referral")
public class UserReferral {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "referrer_id")
  private User referrer;

  @ManyToOne
  @JoinColumn(name = "referee_id", unique = true)
  private User referee;

  // Getters and setters
  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public User getReferrer() {
    return referrer;
  }
  public void setReferrer(User referrer) {
    this.referrer = referrer;
  }
  public User getReferee() {
    return referee;
  }
  public void setReferee(User referee) {
    this.referee = referee;
  }
}
