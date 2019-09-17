package com.stack.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	private String stockName;
	private double unitPrice;
	private LocalDate stockCreatedOn;
	private int criselRating;
	
}
