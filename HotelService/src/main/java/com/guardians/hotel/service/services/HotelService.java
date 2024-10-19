package com.guardians.hotel.service.services;

import com.guardians.hotel.service.enitites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel get(String id);
}
