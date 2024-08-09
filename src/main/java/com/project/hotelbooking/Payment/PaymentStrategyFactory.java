package com.project.hotelbooking.Payment;

public class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(String type) {
        switch (type) {
            case "CREDIT_CARD":
                return new CreditCardPaymentStrategy();
            case "PAYPAL":
                return new PayPalPaymentStrategy();
            // Add more payment methods here
            default:
                throw new IllegalArgumentException("Invalid payment method");
        }
    }
}
