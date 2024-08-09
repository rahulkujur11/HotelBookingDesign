package com.project.hotelbooking.Models;

import java.util.List;

public class User {

    private String userId;
    private String name;
    private String email;
    private String phone;
    private List<Booking> bookings;

    public User(String userId, String name, String email, String phone, List<Booking> bookings) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bookings = bookings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
