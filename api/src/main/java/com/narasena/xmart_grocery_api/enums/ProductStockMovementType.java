package com.narasena.xmart_grocery_api.enums;

public enum ProductStockMovementType {
    // Inbound movements (increase stock)
    PURCHASE,           // Receiving from suppliers
    TRANSFER_IN,        // From other stores/warehouses
    RETURN_FROM_CUSTOMER, // Customer returns
    ADJUSTMENT_IN,      // Manual increase (found inventory)
    
    // Outbound movements (decrease stock)
    SALE,              // Customer purchases
    TRANSFER_OUT,      // To other stores/warehouses
    EXPIRED,           // Expired products removal
    DAMAGED,           // Damaged goods write-off
    THEFT,             // Shrinkage due to theft
    ADJUSTMENT_OUT,    // Manual decrease (lost inventory)
    PROMOTION_LOSS,    // Free samples, promotions
    WASTE             // Spoiled/unsellable items
}
