package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private java.util.List<CartItem> cartItems;
    
    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public java.util.List<CartItem> getCartItems() { return cartItems; }
    public void setCartItems(java.util.List<CartItem> cartItems) { this.cartItems = cartItems; }
}