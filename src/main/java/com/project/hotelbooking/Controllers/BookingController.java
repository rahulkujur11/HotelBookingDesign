package com.project.hotelbooking.Controllers;


import com.project.hotelbooking.Models.*;
import com.project.hotelbooking.Payment.PaymentFacade;
import com.project.hotelbooking.Repository.BookingRequest;
import com.project.hotelbooking.Services.BookingService;
import com.project.hotelbooking.Services.NotificationService;
import com.project.hotelbooking.Services.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class BookingController {

    @GetMapping("/home")
    public String showForm(Model model) {
        BookingRequest bookingRequest = new BookingRequest();
        model.addAttribute("bookingRequest", bookingRequest);
        return "index"; // This maps to src/main/resources/templates/index.htm
    }

    @GetMapping("/bookform")
    public String showBookingPage(Model model) {
        BookingRequest bookingRequest = new BookingRequest();
        model.addAttribute("bookingRequest", bookingRequest);
        return "bookform";  // Return the name of the template (e.g., booking.html)
    }


    @PostMapping("/book")
    public String processBooking(@ModelAttribute BookingRequest bookingRequest, Model model) {
        // Create dummy user and hotel for simplicity
        User user = new User("user1", bookingRequest.getUserName(), bookingRequest.getEmail(),"1234567890", new ArrayList<>());
        Hotel hotel = new Hotel("hotel1", bookingRequest.getHotelName(), "California", new ArrayList<>(), new ArrayList<>());
        Room room = new Room("room1", RoomType.DOUBLE, 200.00, true);
        hotel.getRooms().add(room);

        // Create services
        PaymentService paymentService = new PaymentService();
        NotificationService notificationService = new NotificationService();
        paymentService.addObserver(notificationService);

        PaymentFacade paymentFacade = new PaymentFacade(paymentService, notificationService);
        BookingService bookingService = new BookingService(paymentFacade);
        bookingService.addObserver(notificationService);

        // Book a room
        LocalDate checkIn = LocalDate.parse(bookingRequest.getCheckInDate());
        LocalDate checkOut = LocalDate.parse(bookingRequest.getCheckOutDate());
        Booking booking = bookingService.bookRoom(user, hotel, room, checkIn, checkOut, bookingRequest.getPaymentType());

        // If booking is successful, redirect to payment
        if (booking.getStatus() == BookingStatus.CONFIRMED) {
            return "redirect:/payment"; // Redirect to payment page
        } else {
            model.addAttribute("bookingStatus", "Booking failed");
            return "paymentResult"; // This maps to src/main/resources/templates/result.htm
        }
    }
}
