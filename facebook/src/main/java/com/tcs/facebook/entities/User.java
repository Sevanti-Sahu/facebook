package com.tcs.facebook.entities;

import java.sql.Date;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer","handler"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String fName;
	public String lName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	public Set<Post> post;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Set<Post> getPost() {
		return post;
	}
	public void setPost(Set<Post> post) {
		this.post = post;
	}
	
	
	/*public Set<Post> findByStartDateBetween(Date dt1,Date dt2)
	{
		return null;
	}*/
	
	

	
}
