package com.stack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.dto.LoginDetailsDto;
import com.stack.dto.LoginDto;
import com.stack.entity.User;
import com.stack.respository.UserRepository;



@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginDetailsDto login(LoginDto loginDto) {
		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		User user = userRepository.findByEmailAndPassword(loginDto.getEmailId(), loginDto.getPassword());
		
		if (user != null) {
			LOGGER.info("user fetched");
			loginResponseDto.setUserId(user.getUserId());
			loginResponseDto.setMessage("LoggedIn Successfully..");
			loginResponseDto.setStatus("SUCCESS");
			loginResponseDto.setStatusCode(200);
			return loginResponseDto;
		} else {
			loginResponseDto.setMessage("Login Failed...");
			loginResponseDto.setStatus("FAILURE");
			loginResponseDto.setStatusCode(200);
			return loginResponseDto;
		}

	}

}
