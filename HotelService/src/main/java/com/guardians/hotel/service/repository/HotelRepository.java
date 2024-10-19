package com.guardians.hotel.service.repository;

import com.guardians.hotel.service.enitites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
