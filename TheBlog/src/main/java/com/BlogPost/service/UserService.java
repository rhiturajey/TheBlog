package com.BlogPost.service;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogPost.entity.Users;
import com.BlogPost.repository.UserRepository;
import com.BlogPost.utility.Hibernate;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Object validateUser(Users user) {
		Session session=Hibernate.getSessionFactory().openSession();
		session.beginTransaction();
		Users dbUser=userRepository.findByUserName(user.getUserName()).get();
		
		if(dbUser!=null)
			{
				if(dbUser.getPassword().equals(user.getPassword())) {
					dbUser.setLastLogin(new Timestamp(new Date().getTime()));
					userRepository.save(dbUser);
					session.close();
					return dbUser;
				}
			};
			session.close();
		return dbUser;
	}
	
}
