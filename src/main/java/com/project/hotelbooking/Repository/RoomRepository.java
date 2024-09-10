package com.project.hotelbooking.Repository;

import com.project.hotelbooking.Models.Room;
import com.project.hotelbooking.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findById(Long roomId);
}