package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "store_addresses")
public class StoreAddress extends BaseAddressEntity {
  @OneToOne
  @JoinColumn(name = "store_id")
  private Store store;
}
