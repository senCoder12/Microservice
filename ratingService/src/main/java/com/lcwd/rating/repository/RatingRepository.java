package com.lcwd.rating.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.rating.entities.Rating;
import java.util.List;


public interface RatingRepository extends MongoRepository<Rating, String> {
    

    //Custom finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
