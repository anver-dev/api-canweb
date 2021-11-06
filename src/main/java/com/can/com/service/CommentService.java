package com.can.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.can.com.model.Comment;
import com.can.com.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> getCommentsByCenter(Long centerId) {
		
		List<Comment> comments = commentRepository.findAll();
		List<Comment> commentsByCenterId = new ArrayList<Comment>();
		
		for (Comment comment : comments) {
			if(comment.getCenter().getId().equals(centerId))
				commentsByCenterId.add(comment);
		}
		
		return commentsByCenterId;
	}
}
