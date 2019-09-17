package com.stack.service;

import com.stack.dto.PriceRequestDTO;
import com.stack.dto.PriceResDTO;
import com.stack.dto.StockResponseDto;

public interface StockService {
	PriceResDTO getUpdatedPrice(PriceRequestDTO requestDto);

	StockResponseDto getStockList();
	public PriceResDTO getTotalPrice(PriceRequestDTO priceRequestDTO);
}
