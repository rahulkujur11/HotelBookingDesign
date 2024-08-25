package com.project.hotelbooking;

import com.project.hotelbooking.Models.*;
import com.project.hotelbooking.Payment.PaymentFacade;
import com.project.hotelbooking.Services.BookingService;
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
}
