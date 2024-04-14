package com.ticket.myticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.myticket.dto.LoginRequestDTO;
import com.ticket.myticket.dto.LoginResponseDTO;
import com.ticket.myticket.dto.UserRequestDTO;
import com.ticket.myticket.dto.UserResponseDTO;
import com.ticket.myticket.model.User;
import com.ticket.myticket.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userRequestDTO) {
		return new ResponseEntity<>(userService.createUser(userRequestDTO), HttpStatus.CREATED);

	}
	
	@PostMapping("/login/token")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
		return new ResponseEntity<>(userService.login(loginRequestDTO), HttpStatus.OK);
	}
}
