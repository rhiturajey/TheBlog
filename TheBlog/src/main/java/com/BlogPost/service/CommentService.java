package com.BlogPost.service;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogPost.entity.Comments;
import com.BlogPost.entity.Timeline;
import com.BlogPost.repository.CommentRepository;
import com.BlogPost.repository.PostRepository;
import com.BlogPost.utility.Hibernate;

@Service
public class CommentService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;
	
	public void addComment(Comments comment) {
	
		Session session=Hibernate.getSessionFactory().openSession();
		session.beginTransaction();
		
		comment.setCommentedAt(new Timestamp(new Date().getTime()));
		Timeline timeline=postRepository.findByPostId(comment.getTimeline().getPostId());
		timeline.setCommentCount((timeline.getCommentCount())+1);
		postRepository.save(timeline);

		commentRepository.save(comment);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public List<Comments> showComments(Integer postId) {
		
		return null;
		
	}
}
