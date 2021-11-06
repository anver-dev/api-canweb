package com.can.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.can.com.dto.CenterDto;
import com.can.com.model.Center;
import com.can.com.repository.CenterRepository;

@Service
public class CenterService {
	
	@Autowired
	private CenterRepository centerRepository;
	
	public List<CenterDto> getAll() {
		List<CenterDto> centerDtos = new ArrayList<CenterDto>();
		List<Center> centers = centerRepository.findAll();
		for (Center center : centers) {
			centerDtos.add(CenterDto.creaDto(center));
		}
		return centerDtos;
	}

	public Center save(Center center) {
		return centerRepository.save(center);
		
	}
}
