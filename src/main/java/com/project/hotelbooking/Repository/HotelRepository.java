package com.project.hotelbooking.Repository;

import com.project.hotelbooking.Models.Hotel;
import com.project.hotelbooking.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findById(Long hotelId);
}