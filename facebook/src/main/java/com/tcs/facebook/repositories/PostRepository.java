package com.tcs.facebook.repositories;

import java.sql.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.facebook.entities.Post;
import com.tcs.facebook.entities.User;

public interface PostRepository extends JpaRepository<Post, Long>{

	@Query("select p from Post p where p.user.id = ?1 and p.sqlDate between ?2 and ?3")
	public Set<Post> findByStartDateBetween(Long id , Date startDate,Date endDate);
	
	//@Query("select u from User u inner join u.post p where u.id=p.user.id and u.id = ?1 and p.sqlDate between ?2 and ?3 ")
	//public User findByStartDateBetween1(Long id , Date startDate,Date endDate);
}
