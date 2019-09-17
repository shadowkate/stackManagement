package com.stack.service;

import org.springframework.stereotype.Service;

@Service
public class StockPriceCalculation {

	private final static double brockarage = 10;

	public double calculateStock(int quantity, double unitPrice) {
		return unitPrice * quantity + (unitPrice * quantity) / brockarage;
	}
}
