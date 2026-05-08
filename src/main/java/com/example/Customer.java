package com.example;

public class Customer {
    private String id;
    private String email;
    private String membershipTier; // "GOLD", "SILVER", null for guest
    
    public Customer(String id, String email, String membershipTier) {
        this.id = id;
        this.email = email;
        this.membershipTier = membershipTier;
    }
    
    public double getLoyaltyDiscount() {
        if ("GOLD".equals(membershipTier)) return 0.15;
        if ("SILVER".equals(membershipTier)) return 0.08;
        return 0.0;
    }
    
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getMembershipTier() { return membershipTier; }
}
