package com.stack.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceRequestDTO {

	private int stockId;
	private int quantity;
	private double unitPrice;
}
