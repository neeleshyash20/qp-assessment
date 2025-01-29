package com.grocery.dto;

public class OrderRequestItems {

    private int quantity;

    private long groceryItemId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getGroceryItemId() {
        return groceryItemId;
    }

    public void setGroceryItemId(long groceryItemId) {
        this.groceryItemId = groceryItemId;
    }
}
