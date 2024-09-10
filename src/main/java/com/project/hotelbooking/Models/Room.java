package com.project.hotelbooking.Models;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long roomId;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private double pricePerNight;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel; // Many rooms can belong to one hotel

    // Constructors, getters, and setters
    public Room() {}

    public Room(RoomType roomType, double pricePerNight, boolean isAvailable, Hotel hotel) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
        this.hotel = hotel;
    }

    // Getters and setters...

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
