/**
 * 
 */
package com.resturantservice.dto;

public class ItemRequest {
    // Menu item ID
    private int itemId;

    // Quantity of the item
    private int quantity;

    // Constructors
    public ItemRequest() {}

    public ItemRequest(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
