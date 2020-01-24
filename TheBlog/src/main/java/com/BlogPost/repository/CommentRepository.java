package com.BlogPost.repository;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BlogPost.entity.Comments;

@Repository
public interface CommentRepository extends CrudRepository<Comments, Timestamp> {

}
