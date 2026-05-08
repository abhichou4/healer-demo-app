package com.example;

import java.util.List;

public class Order {
    private String id;
    private Customer customer; // null for guest checkouts
    private List<OrderItem> items;
    private String paymentMethod;
    private double totalAmount;
    
    public Order(String id, Customer customer, List<OrderItem> items, String paymentMethod, double totalAmount) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
    }
    
    public String getId() { return id; }
    public Customer getCustomer() { return customer; } // returns null for guest orders
    public List<OrderItem> getItems() { return items; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getTotalAmount() { return totalAmount; }
}
