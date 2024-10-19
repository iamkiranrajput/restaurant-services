package com.guardians.user.service;

import com.guardians.user.service.entities.Rating;
import com.guardians.user.service.external.services.RatingService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating(){
		Rating rating  = Rating.builder().rating(10).userId("").hotelId("").remark("this is created for testing purpose").build();
		Rating savedRating = ratingService.createdsRating(rating);

		System.out.println("new rating created");
	}

}
