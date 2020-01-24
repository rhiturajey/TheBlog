package com.BlogPost.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Comments {

	
	private String comment;
	@Id
	private Timestamp commentedAt;
	
	
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "postId", nullable = false)
	private Timeline timeline;
	
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "userName", nullable = false)
	private Users user;
    
	public Timeline getTimeline() {
		return timeline;
	}
	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getCommentedAt() {
		return commentedAt;
	}
	public void setCommentedAt(Timestamp commentedAt) {
		this.commentedAt = commentedAt;
	}
	@Override
	public String toString() {
		return "Comments [comment=" + comment + ", commentedAt=" + commentedAt + ", timeline=" + timeline + ", user="
				+ user + "]";
	}

	
}
