package com.stack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stack.dto.PutOrderDto;
import com.stack.dto.PutOrderResponseDto;
import com.stack.service.PutOrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class PutOrderController {

	@Autowired
	PutOrderService putService;
	
	@PostMapping("/order")
	public ResponseEntity<PutOrderResponseDto> putData(@RequestBody PutOrderDto putOrder)
	{
		return new ResponseEntity<PutOrderResponseDto>(putService.addOrder(putOrder),HttpStatus.OK);
	}
	
}
