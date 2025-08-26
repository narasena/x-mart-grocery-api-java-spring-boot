package com.narasena.xmart_grocery_api.enums;

public enum VoucherStatus {
    ISSUED,     // Generated for user
    ACTIVE,     // Ready to use
    USED,       // Already redeemed
    EXPIRED,    // Time expired
    CANCELLED   // Manually cancelled
}