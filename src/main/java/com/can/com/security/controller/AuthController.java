package com.can.com.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.can.com.dto.Message;
import com.can.com.security.dto.JwtDto;
import com.can.com.security.dto.LoginUser;
import com.can.com.security.dto.NewUser;
import com.can.com.security.enums.RolName;
import com.can.com.security.jwt.JwtProvider;
import com.can.com.security.model.Rol;
import com.can.com.security.model.User;
import com.can.com.security.model.UserPrincipal;
import com.can.com.security.service.RolService;
import com.can.com.security.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private RolService rolService;

	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/register")
	@SuppressWarnings({ "rawtypes", "unchecked", "unlikely-arg-type" })
	public ResponseEntity<?> register(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Message("Parametros invalidos"), HttpStatus.BAD_REQUEST);
		if (userService.existsByUsername(newUser.getUsername()))
			return new ResponseEntity(new Message("El usuario ya esta registrado"), HttpStatus.CONFLICT);
		if (userService.existsByEmail(newUser.getEmail()))
			return new ResponseEntity(new Message("El usuario ya esta registrado"), HttpStatus.CONFLICT);

		User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
				passwordEncoder.encode(newUser.getPassword()));

		Set<Rol> roles = new HashSet<Rol>();
		roles.add(rolService.getRolByName(RolName.ROL_USER).get());
		if (newUser.getRoles().contains("admin"))
			roles.add(rolService.getRolByName(RolName.ROL_ADMIN).get());
		if (newUser.getRoles().contains("center"))
			roles.add(rolService.getRolByName(RolName.ROL_CENTER).get());
		user.setRoles(roles);

		userService.save(user);

		return new ResponseEntity(new Message("El usuario fue creado con éxito"), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Message("Parametros invalidos"), HttpStatus.BAD_REQUEST);

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.genereteToken(authentication);
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		
		JwtDto jwtDto = new JwtDto(jwt, userPrincipal.getUsername(), userPrincipal.getId(), userPrincipal.getAuthorities());
		
		return new ResponseEntity(jwtDto, HttpStatus.OK);

	}
}
