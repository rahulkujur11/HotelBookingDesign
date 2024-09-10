package com.project.hotelbooking.Models;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates IDs for each booking
    private Long id;  // Primary key

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Foreign key for the user
    private Users user;

    @ManyToOne
    @JoinColumn(name = "hotel_id")  // Foreign key for the hotel
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "room_id")  // Foreign key for the room
    private Room room;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public Booking(Users user, Hotel hotel, Room room, LocalDate checkInDate, LocalDate checkOutDate, BookingStatus bookingStatus) {
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = bookingStatus;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
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

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
