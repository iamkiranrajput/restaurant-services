package com.guardians.hotel.service.controller;

import com.guardians.hotel.service.enitites.Hotel;
import com.guardians.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping("")
    public ResponseEntity<Hotel> AddHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> hotelList = hotelService.getAll();
        return new ResponseEntity(hotelList, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<List<Hotel>> getHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.get(hotelId);
        return new ResponseEntity(hotel, HttpStatus.OK);
    }


}
