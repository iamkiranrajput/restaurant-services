package com.guardians.user.service.external.services;

import com.guardians.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public Rating createdsRating(Rating values);

    @PutMapping("ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("ratings/{ratingId}")
    Rating deleteRating(@PathVariable("ratingId") String ratingId);
}
