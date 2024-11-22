package com.resturantservice.dto;

import java.util.List;



public class OrderRequest {
    // Customer ID who is placing the order
    private Long customerId;

    // Restaurant ID where the order is being placed
    private Long restaurantId;

    // List of items being ordered
    private List<ItemRequest> items;

    // Optional: Delivery address (in case it's not part of the customer profile)
    private String deliveryAddress;

    // Optional: Additional instructions for the order
    private String instructions;

    // Payment method (e.g., Cash, Card, Wallet)
    private String paymentMethod;

    // Constructors
    public OrderRequest() {}

    public OrderRequest(Long customerId, Long restaurantId, List<ItemRequest> items, String deliveryAddress, String instructions, String paymentMethod) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.instructions = instructions;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "customerId=" + customerId +
                ", restaurantId=" + restaurantId +
                ", items=" + items +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", instructions='" + instructions + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}

