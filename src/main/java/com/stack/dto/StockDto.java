package com.stack.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockDto {
	
	private int stockId;
	private String stockName;
	private Double unitPrice;
	private int rating;
	
}
