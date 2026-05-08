package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    private final OrderService orderService;
    
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @PostMapping
    public OrderResult createOrder(@RequestBody Order order) {
        return orderService.processOrder(order);  // LINE 67
    }
    
    @GetMapping("/{customerId}/history")
    public java.util.List<Order> getOrderHistory(@PathVariable String customerId) {
        return orderService.getOrderHistory(customerId);
    }
}
