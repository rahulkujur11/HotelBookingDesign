package com.project.hotelbooking.Models;

import java.time.LocalDate;

public class Booking {
    private String bookingId;
    private User user;
    private Hotel hotel;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BookingStatus status;

    // Constructors, getters, setters

    public Booking(String bookingId, User user, Hotel hotel, Room room, LocalDate checkInDate, LocalDate checkOutDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}

