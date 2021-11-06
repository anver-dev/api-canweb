package com.can.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.can.com.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
