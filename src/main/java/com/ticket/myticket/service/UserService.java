package com.ticket.myticket.service;

import com.ticket.myticket.dto.LoginRequestDTO;
import com.ticket.myticket.dto.LoginResponseDTO;
import com.ticket.myticket.dto.UserRequestDTO;

public interface UserService {

	public String createUser(UserRequestDTO userRequestDTO);

	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
