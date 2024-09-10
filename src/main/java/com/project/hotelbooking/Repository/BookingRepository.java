package com.project.hotelbooking.Repository;

import com.project.hotelbooking.Models.Booking;
import com.project.hotelbooking.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findById(long bookingId);
}