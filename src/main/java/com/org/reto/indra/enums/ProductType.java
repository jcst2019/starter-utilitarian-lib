package com.org.reto.indra.enums;

public enum ProductType {
    SAVINGS_ACCOUNT(1, "Savings Account"),
    CREDIT_CARD(2, "Credit Card"),
    CHECKING_ACCOUNT(3, "Checking Account");

    private final int type;
    private final String name;

    ProductType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static ProductType fromType(int type) {
        for (ProductType productType : values()) {
            if (productType.type == type) {
                return productType;
            }
        }
        throw new IllegalArgumentException("Unknown product type: " + type);
    }
}