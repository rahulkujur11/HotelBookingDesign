package com.project.hotelbooking.Controllers;

import com.project.hotelbooking.Payment.PaymentFacade;
import com.project.hotelbooking.Repository.BookingRequest;
import com.project.hotelbooking.Services.BookingService;
import com.project.hotelbooking.Services.NotificationService;
import com.project.hotelbooking.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// PaymentController.java
@Service
@RestController
@Controller
public class PaymentController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PaymentFacade paymentFacade;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/payment")
    public String showPaymentForm(Model model) {
        BookingRequest bookingRequest = new BookingRequest(); // You might need to fetch the booking request from a session or database
        model.addAttribute("bookingRequest", bookingRequest);
        return "payment"; // This maps to src/main/resources/templates/payment.htm
    }

    @PostMapping("/processPayment")
    public String processPayment(@ModelAttribute BookingRequest bookingRequest, Model model) {
        // Process payment through facade
        boolean paymentSuccess = paymentFacade.processOrderPayment(bookingRequest.getPaymentType(), bookingRequest.getAmount());

        // Update model with payment status
        model.addAttribute("paymentStatus", paymentSuccess ? "Payment successful" : "Payment failed");

        return "paymentResult"; // This maps to src/main/resources/templates/paymentResult.htm
    }
}