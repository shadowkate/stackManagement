package com.stack.service;

import com.stack.dto.LoginDetailsDto;
import com.stack.dto.LoginDto;


public interface LoginService {

	public LoginDetailsDto login(LoginDto loginDto);

}
