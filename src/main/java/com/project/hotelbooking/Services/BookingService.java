package com.project.hotelbooking.Services;

import com.project.hotelbooking.Models.*;
import com.project.hotelbooking.Notifications.Observable;
import com.project.hotelbooking.Payment.PaymentFacade;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService extends Observable {
    private PaymentFacade paymentFacade;

    public BookingService(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    public Booking bookRoom(User user, Hotel hotel, Room room, LocalDate checkInDate, LocalDate checkOutDate, String paymentType) {
        if (!room.isAvailable()) {
            throw new IllegalStateException("Room is not available");
        }

        Booking booking = new Booking("bookingId", user, hotel, room, checkInDate, checkOutDate, BookingStatus.PENDING);

        // Process payment through facade
        boolean paymentSuccessful = paymentFacade.processOrderPayment(paymentType, room.getPricePerNight());

        if (paymentSuccessful) {
            booking.setStatus(BookingStatus.CONFIRMED);
            room.setAvailable(false);
        } else {
            booking.setStatus(BookingStatus.CANCELLED);
        }
        return booking;
    }

    public void cancelBooking(Booking booking) {
        booking.setStatus(BookingStatus.CANCELLED);
        booking.getRoom().setAvailable(true);
        notifyObservers("Booking cancelled for user: " + booking.getUser().getName());
    }

}

