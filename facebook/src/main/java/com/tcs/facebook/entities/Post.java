package com.tcs.facebook.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer","handler"})
public class Post implements Comparable<Post>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long postId;
	public String message;
	public Date sqlDate;
	public Time sqlTime;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User user;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Comment> comment;
	
	            
	
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		//this.comment = new TreeSet<Comment>(comment) ;
		this.comment = comment;
	}
	public long getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSqlDate() {
		return sqlDate;
	}
	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}
	public Time getSqlTime() {
		return sqlTime;
	}
	public void setSqlTime(Time sqlTime) {
		this.sqlTime = sqlTime;
	}
	@Override
	public int compareTo(Post p1) {
		return(this.getSqlDate().compareTo(p1.getSqlDate()));
	}
	
	
	
}
