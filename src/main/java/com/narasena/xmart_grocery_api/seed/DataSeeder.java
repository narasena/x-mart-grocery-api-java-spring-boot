package com.narasena.xmart_grocery_api.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.narasena.xmart_grocery_api.entity.ProductCategory;
import com.narasena.xmart_grocery_api.entity.ProductSubCategory;
import com.narasena.xmart_grocery_api.repository.ProductCategoryRepository;
import com.narasena.xmart_grocery_api.repository.ProductSubCategoryRepository;


@Component
public class DataSeeder {

  @Bean
  @Transactional(rollbackFor = Exception.class)
  public CommandLineRunner seedData(ProductCategoryRepository productCategoryRepository, ProductSubCategoryRepository productSubCategoryRepository) {
    return args -> {
      String[][] categories = {
          {"Kebutuhan Dapur", "Perlengkapan Dapur & Ruang Makan", "Bahan Masakan", "Bahan Roti & Kue", "Bahan Puding & Agar-Agar"},
          {"Kebutuhan Ibu & Anak", "Perlengkapan Ibu & Bayi", "Makanan Bayi", "Popok & Tisu Basah"},
          {"Kebutuhan Rumah", "Perlengkapan Rumah Tangga", "Alat Kebersihan", "Laundry & Pewangi", "Pest Control"},
          {"Makanan", "Makanan Ringan", "Biskuit & Wafer", "Camilan Tradisional", "Kacang & Buah Kering"},
          {"Minuman", "Air Mineral", "Minuman Kemasan", "Susu & Produk Olahannya", "Kopi, Teh & Cokelat"},
          {"Produk Segar & Beku", "Buah Segar", "Sayur Segar", "Daging Segar", "Seafood Segar"},
          {"Personal Care", "Perawatan Tubuh", "Perawatan Wajah", "Perawatan Rambut", "Perawatan Pria"},
          {"Kebutuhan Kesehatan", "Obat Bebas & Suplemen", "Alat Kesehatan", "Perawatan Luka & Pertolongan Pertama"},
          {"Lifestyle", "Alat Tulis & Kantor", "Elektronik & Aksesoris", "Mainan & Hobi"},
          {"Pet Foods", "Makanan Anjing", "Makanan Kucing", "Aksesoris Hewan Peliharaan"}
      };

      for (String[] cat : categories) {
        if (productCategoryRepository.findByName(cat[0]).isEmpty()) {
          ProductCategory category = new ProductCategory();
          category.setName(cat[0]);
          category.generateSlug();
          productCategoryRepository.save(category);
        }

        ProductCategory productCategory = productCategoryRepository.findByName(cat[0]).get(0);

        for(int i =1; i < cat.length; i++) {
          if(productSubCategoryRepository.findByName(cat[i]).isEmpty()) {
            ProductSubCategory subCategory = new ProductSubCategory();
            subCategory.setName(cat[i]);
            subCategory.setProductCategoryId(productCategory);
            subCategory.generateSlug();
            productSubCategoryRepository.save(subCategory);
          }
        }
      }
    };
  };
}
