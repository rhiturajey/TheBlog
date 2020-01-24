package com.BlogPost.repository;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BlogPost.entity.Likes;

@Repository
public interface LikesRepository extends CrudRepository<Likes, Timestamp> {

}
