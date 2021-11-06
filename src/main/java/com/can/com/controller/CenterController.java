package com.can.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.can.com.dto.CenterDto;
import com.can.com.service.CenterService;

@RestController
@RequestMapping("/centers")
@CrossOrigin
public class CenterController {
	@Autowired
	private CenterService centerService;

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(centerService.getAll());
	}
}
