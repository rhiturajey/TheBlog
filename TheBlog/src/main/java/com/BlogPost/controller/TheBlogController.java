package com.BlogPost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BlogPost.entity.Comments;
import com.BlogPost.entity.Likes;
import com.BlogPost.entity.Timeline;
import com.BlogPost.entity.Users;
import com.BlogPost.service.CommentService;
import com.BlogPost.service.PostService;
import com.BlogPost.service.UserService;

@RestController
@RequestMapping("/")
public class TheBlogController {
	
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	@Autowired
	CommentService commentService;
	
	@RequestMapping(method=RequestMethod.POST, value="/post")
	public void createPost(@RequestBody Timeline timeline) {
		System.out.println("in create");
		postService.createPost(timeline);
		}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public Object authenticateUser(@RequestBody Users user) {
		return userService.validateUser(user);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/timeline")
	public List<Timeline> displayTimeline() {
		return postService.displayAllPost();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/timeline/{userName}")
	public List<Timeline> displayUserPosts(@PathVariable String userName) {
		return postService.displayPostByUserName(userName);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/timeline/liked")
	public void addLike(@RequestBody Likes like) {
		postService.addLike(like);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/timeline/commented")
	public void addComment(@RequestBody Comments comment) {
//		postService.addComment(comment);
	}

}
