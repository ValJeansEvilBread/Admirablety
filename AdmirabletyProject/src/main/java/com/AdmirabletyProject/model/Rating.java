package com.AdmirabletyProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tracking_id")
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "rater_id", referencedColumnName = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User rater;

	@ManyToOne(optional = false)
	@JoinColumn(name = "subject_id", referencedColumnName = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User subject;
	
	private Double rater_rating;
	
	private Integer stars_given;
		
	@CreationTimestamp 
	private Date createdAt;
	
	public Rating() {}

	
	public Rating(Long id, User rater, User subject, Double rater_rating, Integer stars_given, Date createdAt) {
		super();
		this.id = id;
		this.rater = rater;
		this.subject = subject;
		this.rater_rating = rater_rating;
		this.stars_given = stars_given;
		this.createdAt = createdAt;
	}

	public User getRater() {
		return rater;
	}

	public void setRater(User rater) {
		this.rater = rater;
	}

	public User getSubject() {
		return subject;
	}

	public void setSubject(User subject) {
		this.subject = subject;
	}

	public Double getRater_rating() {
		return rater_rating;
	}


	public void setRater_rating(Double rater_rating) {
		this.rater_rating = rater_rating;
	}


	public Integer getStars_given() {
		return stars_given;
	}

	public void setStars_given(Integer stars_given) {
		this.stars_given = stars_given;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rater=" + rater + ", subject=" + subject + ", stars_given=" + stars_given
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
	

}
