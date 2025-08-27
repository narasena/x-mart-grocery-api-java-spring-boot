package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "user_referral")
@Data
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

}