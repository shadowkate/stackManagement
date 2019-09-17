package com.stack.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutOrderDto {
	
	private int userId;
	private int stockId;
	private int quantity;
	private double price;
	private String status;
	private int unitPrice;


}
