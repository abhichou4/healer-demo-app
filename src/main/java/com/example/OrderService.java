package com.example;

import java.util.List;

public class OrderService {
    
    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    
    public OrderService(PaymentService paymentService, InventoryService inventoryService) {
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }
    
    public OrderResult processOrder(Order order) {
        // Validate order
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        
        // Get customer details - can be null for guest checkouts
        Customer customer = order.getCustomer();
        
        // Apply loyalty discount if customer has membership
        double discount = customer.getLoyaltyDiscount();  // LINE 142: NPE if guest checkout (customer is null)
        double finalAmount = order.getTotalAmount() - discount;
        
        // Process payment
        PaymentResult payment = paymentService.charge(order.getPaymentMethod(), finalAmount);
        
        if (!payment.isSuccessful()) {
            throw new PaymentException("Payment failed: " + payment.getErrorMessage());
        }
        
        // Update inventory
        for (OrderItem item : order.getItems()) {
            inventoryService.decrementStock(item.getProductId(), item.getQuantity());
        }
        
        return new OrderResult(order.getId(), payment.getTransactionId(), finalAmount);
    }
    
    public List<Order> getOrderHistory(String customerId) {
        // TODO: implement
        return null;
    }
}
