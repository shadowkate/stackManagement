package com.stack.exception;

public class StockManagementException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public StockManagementException(String message) {
		
		super(message);
	}
}
