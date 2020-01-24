package com.BlogPost.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Timeline implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer postId;
	
	private String post;
	@Column(columnDefinition = "default 0")
	private Integer likeCount=0;
	@Column(columnDefinition = "default 0")

	private Integer commentCount=0;
	
	private Timestamp postedAt;
	
	@ManyToOne
	@JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false)
//    @JsonIgnore
	private Users user;
	

	
	public Timeline() {
		
	}
	
	public Timeline(Integer postId, String post, Integer likeCount, Integer commentCount, Users user) {
		this.postId = postId;
		this.post = post;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
		this.user = user;
	}

	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer i) {
		this.likeCount = i;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Timeline [postId=" + postId + ", post=" + post + ", likeCount=" + likeCount + ", commentCount="
				+ commentCount + ", user=" + user + "]";
	}

	public Timestamp getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Timestamp postedAt) {
		this.postedAt = postedAt;
	}
}
