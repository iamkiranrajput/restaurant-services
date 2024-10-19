package com.guardians.rating.service.controller;


import com.guardians.rating.service.entities.Rating;
import com.guardians.rating.service.services.RatingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){

        List<Rating> rating1 = ratingService.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(rating1);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId){
        List<Rating> rating1 = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(rating1);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        List<Rating> rating1 = ratingService.getRatings();
        return ResponseEntity.status(HttpStatus.OK).body(rating1);
    }



}
