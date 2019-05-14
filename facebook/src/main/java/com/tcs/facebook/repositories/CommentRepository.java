package com.tcs.facebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.facebook.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
