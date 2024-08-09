package com.project.hotelbooking;

import com.project.hotelbooking.Models.*;
import com.project.hotelbooking.Payment.PaymentFacade;
import com.project.hotelbooking.Services.BookingService;
// import com.project.hotelbooking.Services.HotelManagementService;
import com.project.hotelbooking.Services.NotificationService;
import com.project.hotelbooking.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.ArrayList;


@SpringBootApplication
public class HotelBookingSystem {

    private final BookingService bookingService;
    private final PaymentFacade paymentFacade;

    @Autowired
    public HotelBookingSystem(BookingService bookingService, PaymentFacade paymentFacade) {
        this.bookingService = bookingService;
        this.paymentFacade = paymentFacade;
    }

    public Booking bookRoom(User user, Hotel hotel, Room room, LocalDate checkInDate, LocalDate checkOutDate, String paymentMethod) {
        return bookingService.bookRoom(user, hotel, room, checkInDate, checkOutDate, paymentMethod);
    }
//    public static void main(String[] args) {
//// Setup
//        User user = new User("user1", "John Doe", "john@example.com", "1234567890", new ArrayList<>());
//        Hotel hotel = new Hotel("hotel1", "Ocean View", "California", new ArrayList<>(), new ArrayList<>());
//        Room room = new Room("room1", RoomType.DOUBLE, 200.00, true);
//        hotel.getRooms().add(room);
//
//        // Create services
//        PaymentService paymentService = new PaymentService();
//        NotificationService notificationService = new NotificationService();
//
//        // Add NotificationService as an observer
//        paymentService.addObserver(notificationService);
//
//        // Facade pattern - simplify payment processing
//        PaymentFacade paymentFacade = new PaymentFacade(paymentService, notificationService);
//
//        // Booking service
//        BookingService bookingService = new BookingService(paymentFacade);
//        bookingService.addObserver(notificationService);
//
//        // Book a room
//        LocalDate checkIn = LocalDate.now().plusDays(1);
//        LocalDate checkOut = LocalDate.now().plusDays(3);
//        Booking booking = bookingService.bookRoom(user, hotel, room, checkIn, checkOut, "CREDIT_CARD");
//
//        // Output booking details
//        System.out.println("Booking Status: " + booking.getStatus());
//    }
//

}
