package com.project.hotelbooking.Payment;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount) {
        // Implement credit card payment processing logic here
        System.out.println("Processing credit card payment of $" + amount);
        return true;
    }
}
