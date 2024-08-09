package com.project.hotelbooking.Services;

import com.project.hotelbooking.Models.Room;
import org.springframework.stereotype.Service;

@Service
public class HotelManagementService {
    public void updateRoomAvailability(Room room, boolean isAvailable) {
        room.setAvailable(isAvailable);
    }

    public void updateRoomPricing(Room room, double newPrice) {
        room.setPricePerNight(newPrice);
    }
}
