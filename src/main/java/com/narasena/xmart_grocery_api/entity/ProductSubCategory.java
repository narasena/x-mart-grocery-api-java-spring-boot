package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_sub_categories")
@Data
public class ProductSubCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "productSubCategory", cascade = CascadeType.ALL)
    private java.util.List<Product> products;

    @PrePersist
    public void generateSlug() {
        this.slug = generateSlugFromNameandId(this.name, this.id);
    }

    private String generateSlugFromNameandId(String name, Integer id) {
        String baseSlug = name.toLowerCase().replaceAll("[^a-z0-9]+", "-").replaceAll("^-|-$", "");
        return id != null ? baseSlug + "-" + id : baseSlug;
    }

}