package com.project.hotelbooking.Models;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user; // A review is written by one user

    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel; // A review is associated with one hotel

    private int rating; // Assume rating is between 1 to 5
    private String comment;

    // Constructors, getters, and setters
    public Review() {}

    public Review(Users user, Hotel hotel, int rating, String comment) {
        this.user = user;
        this.hotel = hotel;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and setters...

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
