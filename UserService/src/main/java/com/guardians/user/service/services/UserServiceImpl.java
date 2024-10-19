package com.guardians.user.service.services;

import com.guardians.user.service.Zexception.ResourceNotFoundException;
import com.guardians.user.service.entities.Hotel;
import com.guardians.user.service.entities.Rating;
import com.guardians.user.service.entities.User;
import com.guardians.user.service.external.services.HotelService;
import com.guardians.user.service.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }



    public User getUser(String userId) {
        User user =  userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource not found "));
        String ratingUrl = "http://RATING-SERVICE/ratings/user/"+userId;

        Rating[] ratingOfUser = restTemplate.getForObject(ratingUrl, Rating[].class);

        List<Rating> ratingList = Arrays.stream(ratingOfUser).map(rating -> {

//            String hotelUrl = "http://HOTEL-SERVICE/hotels/"+rating.getHotelId();
//            Hotel forEntity= restTemplate.getForObject(hotelUrl, Hotel.class);

//            @calling thorough feign client interface service
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);
        return user;
    }

//    @Override
//    public User getUser(String userId) {
//        User user =  userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource not found "));
//        String ratingUrl = "http://RATING-SERVICE/ratings/user/"+userId;
//
//        Rating[] ratingOfUser = restTemplate.getForObject(ratingUrl, Rating[].class);
//
//        List<Rating> ratingList = Arrays.stream(ratingOfUser).map(rating -> {
//            String hotelUrl = "http://HOTEL-SERVICE/hotels/"+rating.getHotelId();
//            Hotel forEntity= restTemplate.getForObject(hotelUrl, Hotel.class);
//            rating.setHotel(forEntity);
//
//            return rating;
//        }).collect(Collectors.toList());
//
//
//        user.setRatings(ratingList);
//        return user;
//    }
}
