package com.can.com.dto;

import javax.validation.constraints.NotNull;

import com.can.com.model.Center;
import com.can.com.security.model.User;

import lombok.Data;

@Data
public class CenterDto {
	
	private Long id;
	
	@NotNull
	private User user;
	
	public static CenterDto creaDto(Center center) {
		CenterDto centerDto = new CenterDto();
		User userCenter = new User();
		
		userCenter.setId(center.getUser().getId());
		userCenter.setName(center.getUser().getName());
		userCenter.setEmail(center.getUser().getEmail());
		userCenter.setUbication(center.getUser().getUbication());
		
		centerDto.setUser(userCenter);
		centerDto.setId(center.getId());
		
		return centerDto;
	}
}
