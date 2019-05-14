package com.tcs.facebook.repositories;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tcs.facebook.entities.User;


public interface userRepository extends JpaRepository<User,Long>{
	
	@Query("select u from User u  where u.fName = ?1")
	 public Set<User> findByName(String name1);

}
