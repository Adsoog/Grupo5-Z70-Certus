package com.review.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.review.service.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
	
	List<Review> findByPuntuacion(int puntuacion);

}
