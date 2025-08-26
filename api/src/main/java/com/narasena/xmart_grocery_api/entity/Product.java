package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, unique = true)
    private String sku;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<ProductImage> productImages;

    @ManyToOne
    @JoinColumn(name = "product_sub_category_id")
    private ProductSubCategory productSubCategory;

    @ManyToOne
    @JoinColumn(name = "product_brand_id")
    private ProductBrand productBrand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<ProductStock> productStocks;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<CartItem> cartItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<PromotionProduct> promotionProducts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private java.util.List<OrderItem> orderItems;
    
    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSku() { return sku; }

    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public java.util.List<ProductImage> getProductImages() { return productImages; }
    public void setProductImages(java.util.List<ProductImage> productImages) { this.productImages = productImages; }
    
    public ProductSubCategory getProductSubCategory() { return productSubCategory; }
    public void setProductSubCategory(ProductSubCategory productSubCategory) { this.productSubCategory = productSubCategory; }
    
    public ProductBrand getProductBrand() { return productBrand; }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }
    
    public java.util.List<ProductStock> getProductStocks() { return productStocks; }

    public void setProductStocks(java.util.List<ProductStock> productStocks) {
        this.productStocks = productStocks;
    }
    
    public java.util.List<CartItem> getCartItems() { return cartItems; }
    public void setCartItems(java.util.List<CartItem> cartItems) { this.cartItems = cartItems; }
    
    public java.util.List<PromotionProduct> getPromotionProducts() { return promotionProducts; }

    public void setPromotionProducts(java.util.List<PromotionProduct> promotionProducts) {
        this.promotionProducts = promotionProducts;
    }
    
    public java.util.List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(java.util.List<OrderItem> orderItems) { this.orderItems = orderItems; }
}