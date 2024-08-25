package com.project.hotelbooking.Payment;

public class PaytmStrategy implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount) {
        return false;
    }
}
