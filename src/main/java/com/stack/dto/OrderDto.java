package com.stack.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
	
	private int quantity;
	private String status;
	private Double totalPrice;
	private String stockName;
	private double unitPrice;
	private LocalDate orderedDate;
}
