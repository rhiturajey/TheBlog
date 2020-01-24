package com.BlogPost.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogPost.entity.Likes;
import com.BlogPost.entity.Timeline;
import com.BlogPost.entity.Users;
import com.BlogPost.repository.LikesRepository;
import com.BlogPost.repository.PostRepository;
import com.BlogPost.repository.UserRepository;
import com.BlogPost.utility.Hibernate;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	LikesRepository likeRepository;
	
	public void addLike(Likes like) {
		Session session=Hibernate.getSessionFactory().openSession();
		session.beginTransaction();
		like.setLikedAt(new Timestamp(new Date().getTime()));

		Timeline timeline=postRepository.findByPostId(like.getTimeline().getPostId());
		timeline.setLikeCount((timeline.getLikeCount())+1);
		postRepository.save(timeline);
		likeRepository.save(like);
		session.getTransaction().commit();
		
		session.close();
		
	}
	

	public void createPost(Timeline timeline) {
		
		Session session=Hibernate.getSessionFactory().openSession();
		
		session.beginTransaction();
		timeline.setPostedAt(new Timestamp(new Date().getTime()));
		postRepository.save(timeline);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public List<Timeline> displayAllPost() {
		Session session=Hibernate.getSessionFactory().openSession();
		
		session.beginTransaction();
		List<Timeline> posts=new ArrayList<>();
		postRepository.findAll().forEach(posts::add);

		session.getTransaction().commit();
		
		session.close();
		return posts;
	}

	public List<Timeline> displayPostByUserName(String userName) {

		Session session=Hibernate.getSessionFactory().openSession();
		
		session.beginTransaction();
		List<Timeline> posts=new ArrayList<>();
		Users user=userRepository.findByUserName(userName).get();

		postRepository.findByUser(user).forEach(posts::add);

		session.getTransaction().commit();
		
		session.close();
		return posts;
	}
}
