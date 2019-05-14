package com.tcs.facebook.entities;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NavigableMap;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer","handler"})
public class Comment implements Comparable<Comment>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long commentId;
	public String commnt;
	public Date commentDate;
	public Time commentTime;
	
	@JsonBackReference
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "post_postId")
	public Post post;
	
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommnt() {
		return commnt;
	}
	public void setCommnt(String commnt) {
		this.commnt = commnt;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Time getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Time commentTime) {
		this.commentTime = commentTime;
	}
	
	
	@Override
	public int compareTo(Comment comm) {
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//		Date date1 = null;
//		Date date2 = null;
//		try {
//			date1 = (Date) sdf.parse(comm.getCommentDate().toString());
//		  date2 = (Date) sdf.parse(this.getCommentDate().toString());
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
			return (this.getCommentDate().compareTo(comm.getCommentDate()));
		//return -1;
	}
	
	                    
	
	

}
