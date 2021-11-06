package com.can.com.dto;

import lombok.Data;

@Data
public class Message {
	private String menssage;

	public Message(String menssage) {
		super();
		this.menssage = menssage;
	}
	
}
