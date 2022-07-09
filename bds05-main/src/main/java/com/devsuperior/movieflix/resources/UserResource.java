package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.services.AuthService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	AuthService authService;
		
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> profileUser() {
		
		User user = authService.authenticated();
		UserDTO userDTO = new UserDTO(user);
		
		return ResponseEntity.ok().body(userDTO);
	}	
} 
