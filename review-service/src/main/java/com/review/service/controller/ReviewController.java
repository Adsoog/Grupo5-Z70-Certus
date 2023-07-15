package com.review.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.review.service.model.Review;
import com.review.service.service.ReviewService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/resenas")
public class ReviewController {
	
	@Autowired
    private ReviewService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@RequestBody Review review){
        return service.addReview(review);
    }

    @GetMapping
    public List<Review> getReview() {
        return service.findAllReviews();
    }


    @GetMapping("/{reviewId}")
    public Review getReview(@PathVariable String reviewId){
        return service.getReviewByReviewId(reviewId);
    }

    @GetMapping("/puntuacion/{puntuacion}")
    public List<Review> findReviewUsingPuntuacion(@PathVariable int puntuacion){
        return service.getReviewByPuntuacion(puntuacion);
    }


    @PutMapping
    public Review modifyReview(@RequestBody Review review){
        return service.updateReview(review);
    }

    @DeleteMapping("/{reviewId}")
    public String deleteReview(@PathVariable String reviewId){
        return service.deleteReview(reviewId);
    }

}
