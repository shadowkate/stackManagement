package com.stack.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutOrderResponseDto {

	private String message; 
	private int statusCode;
	private String status;
	private int orderId;

	
}
