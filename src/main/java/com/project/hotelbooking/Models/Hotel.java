package com.project.hotelbooking.Models;

import java.util.List;

public class Hotel {
    private String hotelId;
    private String name;
    private String location;
    private List<Room> rooms;
    private List<Review> reviews;

    public Hotel(String hotelId, String name, String location, List<Room> rooms, List<Review> reviews) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.rooms = rooms;
        this.reviews = reviews;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
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
