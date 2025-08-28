package com.narasena.xmart_grocery_api.service;

import com.narasena.xmart_grocery_api.entity.Product;
import com.narasena.xmart_grocery_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}