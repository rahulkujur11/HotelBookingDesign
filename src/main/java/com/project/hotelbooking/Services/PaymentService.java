package com.project.hotelbooking.Services;

import com.project.hotelbooking.Notifications.Observable;
import com.project.hotelbooking.Notifications.Observer;
import com.project.hotelbooking.Payment.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService extends Observable {
    private PaymentStrategy paymentStrategy;
    private List<Observer> observers = new ArrayList<>();

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public boolean processPayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        boolean success = paymentStrategy.processPayment(amount);
        notifyObservers(success ? "Payment successful" : "Payment failed");
        return success;
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

