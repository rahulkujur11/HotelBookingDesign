package com.project.hotelbooking.Payment;

public interface PaymentStrategy {
    boolean processPayment(double amount);
}
