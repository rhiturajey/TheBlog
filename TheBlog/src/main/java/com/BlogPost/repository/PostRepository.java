package com.BlogPost.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BlogPost.entity.Timeline;
import com.BlogPost.entity.Users;

@Repository
public interface PostRepository extends CrudRepository<Timeline, Users> {

	public List<Timeline> findByUser(Users user);
	public Timeline findByPostId(Integer postId);
	

}
