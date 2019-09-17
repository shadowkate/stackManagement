package com.stack.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stack.dto.LoginDetailsDto;
import com.stack.dto.LoginDto;
import com.stack.entity.User;
import com.stack.respository.UserRepository;
import com.stack.service.LoginServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	LoginServiceImpl loginService;
	
	LoginDto loginDto = null;
	LoginDetailsDto loginDetailsDto = null;
	LoginDetailsDto loginDetailsDto1 = null;
	User user = null;
	
	@Before
	public void setup() {
		user = new User();
		user.setUserId(1);
		user.setEmail("sai@gmail.com");
		loginDto = new LoginDto();
		loginDto.setEmailId("sai@gmail.com");
		loginDto.setPassword("test@123");
		loginDetailsDto = new LoginDetailsDto();
		loginDetailsDto.setMessage("LoggedIn Successfully..");
		loginDetailsDto.setStatus("SUCCESS");
		loginDetailsDto.setStatusCode(200);
		loginDetailsDto.setUserId(user.getUserId());
		loginDetailsDto1 = new LoginDetailsDto();
		loginDetailsDto1.setMessage("Login Failed...");
		loginDetailsDto1.setStatus("FAILURE");
		loginDetailsDto1.setStatusCode(200);
		
	
	}
	
	@Test
	public void loginSuccessTest() {
		Mockito.when(userRepository.findByEmailAndPassword("sai@gmail.com", "test@123")).thenReturn(user);
		assertEquals(loginDetailsDto.toString(), loginService.login(loginDto).toString());
	}
	
	@Test
	public void loginNullTest() {
		Mockito.when(userRepository.findByEmailAndPassword("sai@gmail.com", "lak")).thenReturn(null);
		assertEquals(loginDetailsDto1.toString(), loginService.login(loginDto).toString());
	}
}
