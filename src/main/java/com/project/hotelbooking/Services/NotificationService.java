package com.project.hotelbooking.Services;

import com.project.hotelbooking.Notifications.Observer;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements Observer {

    @Override
    public void update(String message) {
        sendNotification(message);
    }

    private void sendNotification(String message) {
        // Logic to send notification (e.g., via email, SMS, etc.)
        System.out.println("Notification sent: " + message);
    }
    public void sendPaymentConfirmation() {
        System.out.println("Sending payment confirmation...");
    }



//    public void sendBookingConfirmation(User user, Booking booking) {
//        // Implement email/SMS notification logic here
//        System.out.println("Sending booking confirmation to " + user.getEmail());
//    }
//
//    public void sendBookingCancellation(User user, Booking booking) {
//        // Implement email/SMS notification logic here
//        System.out.println("Sending booking cancellation to " + user.getEmail());
//    }




}
