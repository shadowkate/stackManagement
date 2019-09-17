package com.stack.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResDto {
	
	private int statusCode;
	private String status;
	private String message;
	private List<OrderDto> data;

}
