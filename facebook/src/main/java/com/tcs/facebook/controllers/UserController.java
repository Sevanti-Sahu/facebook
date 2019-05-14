package com.tcs.facebook.controllers;

import com.tcs.facebook.entities.User;
import com.tcs.facebook.entities.Comment;
import com.tcs.facebook.entities.Post;
import com.tcs.facebook.repositories.CommentRepository;
import com.tcs.facebook.repositories.PostRepository;
import com.tcs.facebook.repositories.userRepository;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public userRepository userRepositry;
	
	@Autowired
	public PostRepository postRepository;
	
	@Autowired
	public CommentRepository commRepository;
	
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody User user)
	{
		userRepositry.save(user);
		return new ResponseEntity<String>(" user created",HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<?> GetUser(@RequestParam("user-id") long id)
	{
		    User user = userRepositry.findOne(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
			
		//	Set<Comment> comment = new TreeSet<Comment>(commRepository.findOne(id));
			//return new ResponseEntity<Comment>(comment ,HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> UpdateUser(@RequestBody User user)
	{
	  userRepositry.save(user);
	  return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<?> DeleteUser(@RequestParam("user-id") long id)
	{
		userRepositry.delete(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	@GetMapping("/post")
	public ResponseEntity<?> getPost(@RequestParam("post-id") Long id)
	{
		Post Post = postRepository.findOne(id);
		return new ResponseEntity<Post>(Post ,HttpStatus.OK);
	}
	
	@GetMapping("/comment")
	public ResponseEntity<?> getComment(@RequestParam("comment-id") long id)
	{
		//Comment comm = commRepository.findOne(id);
		User u1 = userRepositry.findOne(id);User u2 = new User();
		Set<Post> post = (u1.getPost());
		//Set<Post> cm = new Set<Post>();
		//TreeSet<Comment> ts = new TreeSet<Comment>();
		for(Post ps :post){
    	TreeSet<Comment> ts = new TreeSet<Comment>();
		ts.addAll(ps.getComment());	
		ps.setComment(ts);
		}
		//output will be sorted comment datewise.
		return new ResponseEntity<User>(u1 ,HttpStatus.OK);
	}
	
	@GetMapping("/sortedPost")
	public ResponseEntity<?> getUser(@RequestParam("user-id") long id,@RequestParam("date-1") Date date1,@RequestParam("date-2") Date date2)
	{
		//User u1 = userRepositry.findOne(id);
		//Set<Post> post = new TreeSet<Post>(u1.findByStartDateBetween(date1,date2));
		Set<Post> post = new TreeSet<Post>(postRepository.findByStartDateBetween(id,date1,date2));
		//User u1 = (postRepository.findByStartDateBetween1(id,date1,date2));
		/*Set<Post> post = new TreeSet<Post>(post.findByStartDateBetween());
		u1.setPost(post);*/
	    /*for (Post ps :post)
	    {
	    	TreeSet<Comment> ts = new TreeSet<Comment>();
	    	ts.addAll(ps.getComment());
	    	ps.setComment(ts);
	    }
	    */
	    return new ResponseEntity<Set<Post>>(post ,HttpStatus.OK);
	}
	
	@GetMapping("/user2")
	public ResponseEntity<?> GetUser(@RequestParam("user-name") String name)
	{
		    Set<User> user = userRepositry.findByName(name);
			return new ResponseEntity<Set<User>>(user,HttpStatus.OK);
			
		//	Set<Comment> comment = new TreeSet<Comment>(commRepository.findOne(id));
			//return new ResponseEntity<Comment>(comment ,HttpStatus.OK);
	}
	
	//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "error")
	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> getExeption(HttpServletRequest request,Exception e)
	{
		logger.error("exception occured : URL = " + request.getRequestURL(),e);
	return new ResponseEntity<String>("Error encountered",HttpStatus.BAD_GATEWAY);
	}
}
