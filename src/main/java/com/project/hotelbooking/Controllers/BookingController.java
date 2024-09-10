package com.project.hotelbooking.Controllers;

import com.project.hotelbooking.Models.*;
import com.project.hotelbooking.Repository.BookingRepository;
import com.project.hotelbooking.Repository.UsersRepository;
import com.project.hotelbooking.Repository.RoomRepository;
import com.project.hotelbooking.Repository.HotelRepository;
import com.project.hotelbooking.Services.BookingRequest;
import com.project.hotelbooking.Services.BookingService;
import com.project.hotelbooking.Services.NotificationService;
import com.project.hotelbooking.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BookingController {

    private BookingRepository bookingRepository;

    private BookingService bookingService;

    private PaymentService paymentService;

    private NotificationService notificationService;

    private UsersRepository usersRepository;

    private RoomRepository roomRepository;

    private HotelRepository hotelRepository;

    // Handle GET request to display all bookings
    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "viewBookings"; // Return view name (JSP or Thymeleaf template)
    }

    @GetMapping("/home")
    public String showForm(Model model) {
        BookingRequest bookingRequest = new BookingRequest();
        model.addAttribute("bookingRequest", bookingRequest);
        return "index"; // This maps to src/main/resources/templates/index.html
    }

    @GetMapping("/bookform")
    public String showBookingPage(Model model) {
        BookingRequest bookingRequest = new BookingRequest();
        model.addAttribute("bookingRequest", bookingRequest);
        return "bookform";  // Return the name of the template (e.g., bookform.html)
    }

    @PostMapping("/book")
    public String processBooking(@ModelAttribute BookingRequest bookingRequest, Model model) {
        // Fetch the user using the repository (instance method, not static)
        Users user = usersRepository.findByUsername(bookingRequest.getUserName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username"));

        // Fetch the hotel
        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));

        // Fetch the room
        Room room = roomRepository.findById(bookingRequest.getRoomId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));

        // Observers for notification and payment processing
        paymentService.addObserver(notificationService); // Assuming the observer pattern is implemented
        bookingService.addObserver(notificationService); // Assuming the observer pattern is implemented

        // Book a room through the service layer
        LocalDate checkIn = LocalDate.parse(bookingRequest.getCheckInDate());
        LocalDate checkOut = LocalDate.parse(bookingRequest.getCheckOutDate());
        Booking booking = bookingService.bookRoom(user, hotel, room, checkIn, checkOut, bookingRequest.getPaymentType());

        // Redirect based on booking status
        if (booking.getStatus() == BookingStatus.CONFIRMED) {
            return "redirect:/payment"; // Redirect to payment page if successful
        } else {
            model.addAttribute("bookingStatus", "Booking failed");
            return "paymentResult"; // Show failure result page
        }
    }
}
