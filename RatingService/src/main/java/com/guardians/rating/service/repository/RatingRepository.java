package com.guardians.rating.service.repository;

import com.guardians.rating.service.entities.Rating;
import com.mongodb.client.MongoChangeStreamCursor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
