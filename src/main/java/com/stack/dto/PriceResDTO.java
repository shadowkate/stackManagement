package com.stack.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceResDTO {

	private String message;
	private int statusCode;
	private String status;
	private double totalPrice;
	
}
