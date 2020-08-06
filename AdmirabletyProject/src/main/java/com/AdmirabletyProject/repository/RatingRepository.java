package com.AdmirabletyProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AdmirabletyProject.model.Rating;
import com.AdmirabletyProject.model.User;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    
	List<Rating> findAllBySubjectOrderByCreatedAtDesc(User subject);
    List<Rating> findAllByRaterOrderByCreatedAtDesc(User rater);
    
    
	List<Rating> findAllByOrderByCreatedAtDesc();
    // List<Rating> findAllByUserOrderByCreatedAtDesc(User user);
    // List<Rating> findAllByUserInOrderByCreatedAtDesc(List<User> users);
}