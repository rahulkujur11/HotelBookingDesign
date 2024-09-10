package com.project.hotelbooking.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // For auto-increment primary key
    private Long hotelId; // Changed from String to Long to support auto-increment

    private String name;
    private String location;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL) // A hotel can have many rooms
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL) // A hotel can have many reviews
    private List<Review> reviews;

    // Constructors, getters, and setters
    public Hotel() {}

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and setters...

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
