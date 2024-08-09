package com.project.hotelbooking.Payment;

import com.project.hotelbooking.Services.NotificationService;
import com.project.hotelbooking.Services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {
    private PaymentService paymentService;
    private NotificationService notificationService;

    public PaymentFacade(PaymentService paymentService, NotificationService notificationService) {
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public boolean processOrderPayment(String paymentType, double amount) {
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(paymentType);
        paymentService.setPaymentStrategy(paymentStrategy);
        boolean paymentSuccess = paymentService.processPayment(amount);

        if (paymentSuccess) {
            notificationService.sendPaymentConfirmation();
        }

        return paymentSuccess;
    }
}
