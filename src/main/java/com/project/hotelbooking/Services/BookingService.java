package com.project.hotelbooking.Services;

import com.project.hotelbooking.Models.*;
import com.project.hotelbooking.Repository.BookingRepository;
import com.project.hotelbooking.Notifications.Observable;
import com.project.hotelbooking.Payment.PaymentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService extends Observable {

    private BookingRepository bookingRepository; // Injecting JPA repository

    private final PaymentFacade paymentFacade;

    public BookingService(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    // Method to book a room
    public Booking bookRoom(Users user, Hotel hotel, Room room, LocalDate checkInDate, LocalDate checkOutDate, String paymentType) {
        // Check if the room is available
        if (!room.isAvailable()) {
            throw new IllegalStateException("Room is not available");
        }

        // Create new booking with status PENDING
        Booking booking = new Booking(user, hotel, room, checkInDate, checkOutDate, BookingStatus.PENDING);

        // Process payment through PaymentFacade
        boolean paymentSuccessful = paymentFacade.processOrderPayment(paymentType, room.getPricePerNight());

        if (paymentSuccessful) {
            booking.setStatus(BookingStatus.CONFIRMED);  // Update booking status to CONFIRMED
            room.setAvailable(false);                   // Mark the room as unavailable
        } else {
            booking.setStatus(BookingStatus.CANCELLED);  // If payment fails, cancel the booking
        }

        // Save the booking to the database using JPA repository
        bookingRepository.save(booking);
        return booking;
    }

    // Method to cancel a booking
    public void cancelBooking(Booking booking) {
        booking.setStatus(BookingStatus.CANCELLED);  // Update status to CANCELLED
        booking.getRoom().setAvailable(true);        // Mark the room as available again

        // Save the updated booking status to the database
        bookingRepository.save(booking);

        // Optionally notify observers
        // notifyObservers("Booking cancelled for user: " + booking.getUser().getName());
    }
}
