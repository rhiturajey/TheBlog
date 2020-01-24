package com.BlogPost.entity;

import java.io.Serializable;

//import java.io.Serializable;

import java.sql.Timestamp;

//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.BlogPost.utility.LikeId;


@Entity
public class Likes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    private Timestamp likedAt;
    

	@ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "postId", nullable = false)
//	@JsonIgnore
	private Timeline timeline;
	
    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false)
//    @JsonIgnore
	private Users users;

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

//    @EmbeddedId
//    private LikeId likeId;
//    
    public Likes() {
    	
    }

	public Timestamp getLikedAt() {
		return likedAt;
	}

	public void setLikedAt(Timestamp likedAt) {
		this.likedAt = likedAt;
	}
//
//	public LikeId getLikeId() {
//		return likeId;
//	}
//
//	public void setLikeId(LikeId likeId) {
//		this.likeId = likeId;
//	}


}
