package com.stack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class CurrentStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int currentStockId;
	private int stockId;
	private double price; 
}
