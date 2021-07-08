package com.stockmarket.core_d.enums;

public enum Events {
    COMPANY_REGISTERED_EVENT("company-registered"),
    COMPANY_DELETED_EVENT("company-deleted"),
    STOCK_PRICE_ADDED_EVENT("stock-price-added"),
    STOCK_PRICE_DELETED_EVENT("stock-price-deleted");

    private String value;

    private Events(String value) { this.value = value; }

    public String getValue() { return this.value; }
}
