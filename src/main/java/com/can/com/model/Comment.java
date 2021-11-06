package com.can.com.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.can.com.security.model.User;

import lombok.Data;

@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String description;
	
	@NotNull
	private Timestamp createdAt;
	
	@NotNull
	@OneToOne
	private User user;
	
	@NotNull
	@OneToOne
	private Center center;

	public Comment() {
		super();
	}
	
	
}
