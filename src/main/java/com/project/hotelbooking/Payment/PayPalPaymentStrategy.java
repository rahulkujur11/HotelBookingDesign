package com.project.hotelbooking.Payment;

public class PayPalPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount) {
        // Implement PayPal payment processing logic here
        System.out.println("Processing PayPal payment of $" + amount);
        return true;
    }
}
