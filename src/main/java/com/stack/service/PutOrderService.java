package com.stack.service;

import org.springframework.stereotype.Service;

import com.stack.dto.PutOrderDto;
import com.stack.dto.PutOrderResponseDto;

@Service
public interface PutOrderService {

	public PutOrderResponseDto addOrder(PutOrderDto putOrderDto);
	
}
