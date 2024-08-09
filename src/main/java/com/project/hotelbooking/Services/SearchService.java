package com.project.hotelbooking.Services;

import com.project.hotelbooking.Models.Hotel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    public List<Hotel> searchHotels(String location, LocalDate checkInDate, LocalDate checkOutDate) {
        // Implement search logic based on location, availability, etc.
        return new ArrayList<>();
    }
}

