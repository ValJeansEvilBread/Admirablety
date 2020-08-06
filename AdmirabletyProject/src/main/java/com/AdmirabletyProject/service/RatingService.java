package com.AdmirabletyProject.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AdmirabletyProject.model.Rating;
import com.AdmirabletyProject.model.RatingDisplay;
import com.AdmirabletyProject.model.User;
import com.AdmirabletyProject.repository.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    
	
    public void save(Rating rating) {
        ratingRepository.save(rating);
    }
    

    
    /* Long-winded way to make the time format look nice (through a RatingDislpay model) */
    private List<RatingDisplay> formatTimestamps(List<Rating> ratings) {
    	List<RatingDisplay> response = new ArrayList<>();
    	PrettyTime prettyTime = new PrettyTime();
    	SimpleDateFormat simpleDate = new SimpleDateFormat("M/d/yy");
    	Date now = new Date();
    	for(Rating rating : ratings) {
    		RatingDisplay ratingDisplay = new RatingDisplay();
    		ratingDisplay.setRater(rating.getRater());
    		ratingDisplay.setSubject(rating.getSubject());
    		ratingDisplay.setStars(rating.getStars_given());
    		long diffInMillies = Math.abs(now.getTime() - rating.getCreatedAt().getTime());
    		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    		if (diff > 3) {
    			ratingDisplay.setDate(simpleDate.format(rating.getCreatedAt()));
    		} else {
    			ratingDisplay.setDate(prettyTime.format(rating.getCreatedAt()));
    		}
    		response.add(ratingDisplay);
    	}
    	return response;
    }
    
    
    
    
    public List<Rating> findLastFiveForSubject(User subject) {
    	List<Rating>ratingsForSubjectList = ratingRepository.findAllBySubjectOrderByCreatedAtDesc(subject);
    	List<Rating> lastFiveRatingsForSubject = ratingsForSubjectList.subList(0, 5);
    	return lastFiveRatingsForSubject;
    }
    
    public List<Rating> findLastFiveForRater(User rater) {
    	List<Rating>ratingsForRaterList = ratingRepository.findAllByRaterOrderByCreatedAtDesc(rater);
    	List<Rating> lastFiveRatingsForRater = ratingsForRaterList.subList(0, 5);
    	return lastFiveRatingsForRater;
    }

    
    
    
    
    
    /*
    public List<Rating> findAll() {
        List<Rating> tweets = ratingRepository.findAllByOrderByCreatedAtDesc();
        return tweets;
    }
    /*
	
  /*  public List<Rating> findAllByUser(User user) {
        List<Rating> tweets = ratingRepository.findAllByUserOrderByCreatedAtDesc(user);
        return tweets;
    }
	
    public List<Rating> findAllByUsers(List<User> users){
        List<Rating> tweets = ratingRepository.findAllByUserInOrderByCreatedAtDesc(users);
        return tweets;
    }
    
   */ 
    
    
    
}
