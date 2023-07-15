package com.review.service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.service.model.Review;
import com.review.service.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
    private ReviewRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Review addReview(Review review) {
        review.setReviewId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(review);
    }

    public List<Review> findAllReviews() {
        return repository.findAll();
    }

    public Review getReviewByReviewId(String reviewId){
        return repository.findById(reviewId).get();
    }

    public List<Review> getReviewByPuntuacion(int puntuacion){
        return  repository.findByPuntuacion(puntuacion);
    }


    public Review updateReview(Review reviewRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
    	Review existingReview = repository.findById(reviewRequest.getReviewId()).get();
        existingReview.setTitulo(reviewRequest.getTitulo());
        existingReview.setPuntuacion(reviewRequest.getPuntuacion());
        existingReview.setResena(reviewRequest.getResena());
        return repository.save(existingReview);
    }

	    public String deleteReview(String reviewId){
	        repository.deleteById(reviewId);
	        return reviewId+" Review deleted from dashboard ";
	    }

}
