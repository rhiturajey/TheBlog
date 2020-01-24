package com.BlogPost.entity;

import java.io.Serializable;
import java.sql.Timestamp;
//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String userName;
	private String password;
	@Column(columnDefinition = "default false")
	private boolean isDeleted;
	private Timestamp LastLogin;
    
//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//	private List<Likes> likes;
//	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Comments> comments;
//	
//	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
//	private Set<Timeline> timeline;
//	
	public Users() {
		
	}
	public Users(String userName, String password, boolean isDeleted, Timestamp lastLogin){
		this.userName = userName;
		this.password = password;
		this.isDeleted = isDeleted;
		LastLogin = lastLogin;
	}
	public Timestamp getLastLogin() {
		return LastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		LastLogin = lastLogin;
	}
	
	public String getUserName() {
		return userName;
	}
//	public Set<Timeline> getTimeline() {
//		return timeline;
//	}
//	public void setTimeline(Set<Timeline> timeline) {
//		this.timeline = timeline;
//	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + ", isDeleted=" + isDeleted + ", LastLogin="
				+ LastLogin + "]";
	}
		
}
