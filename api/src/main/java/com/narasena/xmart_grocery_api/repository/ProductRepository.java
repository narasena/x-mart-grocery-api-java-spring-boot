package com.narasena.xmart_grocery_api.repository;

import com.narasena.xmart_grocery_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    // Spring automatically provides:
    // save(), findById(), findAll(), delete(), etc.
    
    // Custom query methods
    List<Product> findByName(String name);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByNameContaining(String keyword);
}