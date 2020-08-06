package com.AdmirabletyProject.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    
    @Email(message = "Please enter a valid email")
    @NotEmpty(message = "Please enter a valid email")
    private String email;
    
    @NotEmpty(message = "Please enter a username")
    @Length(min = 3, message = "Your username must have at least 3 characters")
    @Length(max = 15, message = "Your username cannot have more than 15 characters")
    @Pattern(regexp="[^\\s]+", message="Your username cannot contain spaces")
    private String username;
    
    @Length(min = 7, message = "Your password must have at least 7 characters")
    @NotEmpty(message = "Please provide a password")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    
    @NotEmpty(message = "Please enter your first name")
    private String firstName;
    
    @NotEmpty(message = "Please enter your city or town of residence")
    private String city;
    
    private String state;
    
    @NotEmpty(message = "Please enter your country of residence")
    private String country;
    
    private int active;
    
    //New unrated users are a 2.0 by default
    public Double overall_rating = 2.0;
    
    private String designation;
    
    @CreationTimestamp 
	private Date createdAt;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tracking_id"))
    private Set<Role> roles;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_tracker", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tracker_id"))
    private List<User> trackers;
    
    @ManyToMany(mappedBy="trackers")
	private List<User> tracking;
    
   //Empty Constructor for JPA
    public User() {}

	public User(Long id,
			@Email(message = "Please provide a valid email") @NotEmpty(message = "Please provide an email") String email,
			@NotEmpty(message = "Please provide a username") @Length(min = 3, message = "Your username must have at least 3 characters") @Length(max = 15, message = "Your username cannot have more than 15 characters") @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces") String username,
			@Length(min = 7, message = "Your password must have at least 7 characters") @NotEmpty(message = "Please provide a password") String password,
			@NotEmpty(message = "Please enter your first name") String firstName,
			@NotEmpty(message = "Please enter your city or town of residence") String city, String state,
			@NotEmpty(message = "Please enter your country of residence") String country, int active,
			Double overall_rating, String designation, Date createdAt, Set<Role> roles, List<User> trackers,
			List<User> tracking) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.active = active;
		this.overall_rating = overall_rating;
		this.designation = designation;
		this.createdAt = createdAt;
		this.roles = roles;
		this.trackers = trackers;
		this.tracking = tracking;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Double getOverall_rating() {
		return overall_rating;
	}

	public void setOverall_rating(Double overall_rating) {
		this.overall_rating = overall_rating;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<User> getTrackers() {
		return trackers;
	}

	public void setTrackers(List<User> trackers) {
		this.trackers = trackers;
	}

	public List<User> getTracking() {
		return tracking;
	}

	public void setTracking(List<User> tracking) {
		this.tracking = tracking;
	}

	public Long getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", active=" + active + ", overall_rating=" + overall_rating + ", designation=" + designation
				+ ", createdAt=" + createdAt + ", roles=" + roles + ", trackers=" + trackers + ", tracking=" + tracking
				+ "]";
	}
	

	
    
    

}

	


