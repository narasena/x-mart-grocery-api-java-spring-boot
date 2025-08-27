package com.narasena.xmart_grocery_api.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_proof")
public class PaymentProof extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne
  @JoinColumn(name = "payment_id", nullable = false)
  private Payment payment;

  @Column(columnDefinition = "TEXT", name = "payment_proof_img_url", nullable = false)
  private String paymentProofImgUrl;

  @Column(columnDefinition = "TEXT", name="resouce_id", nullable = false)
  private String resourceId;

  @Column(name = "is_verified", nullable = false)
  private boolean isVerified = false;

  @ManyToOne
  @JoinColumn(name = "verified_by", nullable = false)
  private User verifiedBy;

  @Column(name = "verified_at", nullable = false)
  private LocalDateTime verifiedAt;

  @Column(columnDefinition = "TEXT")
  private String notes;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public String getPaymentProofImgUrl() {
    return paymentProofImgUrl;
  }

  public void setPaymentProofImgUrl(String paymentProofImgUrl) {
    this.paymentProofImgUrl = paymentProofImgUrl;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public boolean isVerified() {
    return isVerified;
  }

  public void setVerified(boolean verified) {
    isVerified = verified;
  }

  public User getVerifiedBy() {
    return verifiedBy;
  }

  public void setVerifiedBy(User verifiedBy) {
    this.verifiedBy = verifiedBy;
  }

  public LocalDateTime getVerifiedAt() {
    return verifiedAt;
  }

  public void setVerifiedAt(LocalDateTime verifiedAt) {
    this.verifiedAt = verifiedAt;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
