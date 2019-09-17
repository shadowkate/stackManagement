package com.stack.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDetailsDto {
	private String message;
	private Integer userId;
	private String status;
	private Integer statusCode;
}
