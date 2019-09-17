package com.stack.service;

import org.springframework.stereotype.Service;

import com.stack.dto.OrderResDto;

@Service
public interface OrderService {

	OrderResDto getAll(Integer userId);

}
