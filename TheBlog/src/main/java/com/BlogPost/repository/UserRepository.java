package com.BlogPost.repository;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BlogPost.entity.Users;



@Repository
public interface UserRepository extends CrudRepository<Users, String> {

public Optional<Users> findByUserName(String username);
	
}
