package com.BlogPost.utility;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.BlogPost.entity.Timeline;
import com.BlogPost.entity.Users;

@Embeddable
public class LikeId implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId", nullable = false)

	private Timeline timeline;
	
    @ManyToOne
	@Basic(fetch = FetchType.LAZY)
    @JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false)

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

}
