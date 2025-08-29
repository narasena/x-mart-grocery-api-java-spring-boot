package com.narasena.xmart_grocery_api.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_categories")
@Data
public class ProductCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "productCategoryId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductSubCategory> subCategories;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String slug;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @PrePersist
    public void generateSlug() {
        this.slug = generateSlugFromNameandId(this.name, this.id);
    }

    private String generateSlugFromNameandId(String name, Integer id) {
        String baseSlug = name.toLowerCase().replaceAll("[^a-z0-9]+", "-").replaceAll("^-|-$", "");
        return id != null ? baseSlug + "-" + id : baseSlug;
    }
}