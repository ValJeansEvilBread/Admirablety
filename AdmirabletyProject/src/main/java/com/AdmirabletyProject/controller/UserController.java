package com.AdmirabletyProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.AdmirabletyProject.model.Rating;
import com.AdmirabletyProject.model.User;
import com.AdmirabletyProject.service.RatingService;
import com.AdmirabletyProject.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RatingService ratingService;
    
    
    @GetMapping(value = "/users/{username}")
    	public String displayUser(@PathVariable(value="username") String username, Model model) {	
    	    User user = userService.findByUsername(username);
    	    
    	    
    	    
    	    
    	    
    	    List<Rating> ratingsRecieved = ratingService.findLastFiveForSubject(user);
    	    model.addAttribute("ratingsRecievedList", ratingsRecieved);
    	    
    	    List<Rating> ratingsGiven = ratingService.findLastFiveForRater(user);
    	    model.addAttribute("ratingsGivenList", ratingsGiven);
    	    
    	    User loggedInUser = userService.getLoggedInUser();
            List<User> tracking = loggedInUser.getTracking();
            boolean isTracking = false;
            for (User trackedUser : tracking) {
                if (trackedUser.getUsername().equals(username)) {
                    isTracking = true;
                }
            }
            model.addAttribute("tracking", isTracking);
            
            boolean isSelfPage = loggedInUser.getUsername().equals(username);
            model.addAttribute("isSelfPage", isSelfPage);
    	    
    	    model.addAttribute("user", user);
    	    return "user";
    	}
    

    @GetMapping(value = "/users")
    public String getUsers(@RequestParam(value="filter", required=false) 
    	String filter, Model model) {
    	List<User> users = new ArrayList<User>();
    	User loggedInUser = userService.getLoggedInUser();
    	List<User> usersTracking = loggedInUser.getTracking();
    	if (filter == null) {
    	    filter = "all";
    	}
    	if (filter.equalsIgnoreCase("tracking")) {
    	    users = usersTracking;
    	    model.addAttribute("filter", "tracking");
    	}
    	else {
    	    users = userService.findAll();
    	    model.addAttribute("filter", "all");
    	}
    	model.addAttribute("users", users);
    	SetTrackingStatus(users, usersTracking, model);
    	return "users";
    }
    
    
    private void SetTrackingStatus(List<User> users, List<User> usersTracking, Model model) {
        HashMap<String,Boolean> trackingStatus = new HashMap<>();
        String username = userService.getLoggedInUser().getUsername();
        for (User user : users) {
            if(usersTracking.contains(user)) {
                trackingStatus.put(user.getUsername(), true);
            }else if (!user.getUsername().equals(username)) {
                trackingStatus.put(user.getUsername(), false);
        	}
        }
        model.addAttribute("trackingStatus", trackingStatus);
    }
    	
    
}
