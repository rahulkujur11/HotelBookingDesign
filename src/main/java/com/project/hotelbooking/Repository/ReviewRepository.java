package com.project.hotelbooking.Repository;

import com.project.hotelbooking.Models.Review;
import com.project.hotelbooking.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findById(Long reviewId);
}