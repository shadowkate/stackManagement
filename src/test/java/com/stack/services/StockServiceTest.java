package com.stack.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import com.stack.dto.PriceRequestDTO;
import com.stack.dto.PriceResDTO;
import com.stack.dto.StockDto;
import com.stack.dto.StockResponseDto;
import com.stack.entity.CurrentStock;
import com.stack.entity.Stock;
import com.stack.respository.CurrentStockRepositoty;
import com.stack.respository.StockRepository;
import com.stack.service.StockPriceCalculation;
import com.stack.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {

	@Mock
	CurrentStockRepositoty currStockRepository;

	@Mock
	StockPriceCalculation priceCalc;
	
	@Mock
	StockRepository stockRepository;

	@InjectMocks
	StockServiceImpl stockService;

	@Test
	public void getUpdatedPriceTest() {
		CurrentStock currStock = new CurrentStock();
		currStock.setCurrentStockId(1);
		currStock.setPrice(300);
		currStock.setStockId(1);

		PriceRequestDTO reqDTO = new PriceRequestDTO();
		reqDTO.setQuantity(2);
		reqDTO.setStockId(1);

		PriceResDTO respDTO = new PriceResDTO();
		respDTO.setMessage("updated stock price calculated successfully");
		respDTO.setStatus("SUCCESS");
		respDTO.setStatusCode(HttpStatus.OK.value());
		respDTO.setTotalPrice(660.0);

		Mockito.when(currStockRepository.findByStockId(1)).thenReturn(currStock);
	//	Mockito.when(priceCalc.calculateStock(reqDTO.getQuantity(), reqDTO.getUnitPrice())).thenReturn(660.0);

		PriceResDTO actualRes = stockService.getUpdatedPrice(reqDTO);
		assertEquals(respDTO.getMessage(), actualRes.getMessage());
	}

	@Test
	public void getTotalPriceTest() {
		PriceResDTO resp = new PriceResDTO();
		resp.setMessage("Valid OTP");
		resp.setStatus("SUCCESS");
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setTotalPrice(10000);
		PriceRequestDTO req = new PriceRequestDTO();
		req.setQuantity(4);
		req.setStockId(1);
		req.setUnitPrice(100);
		Mockito.when(priceCalc.calculateStock(req.getQuantity(), req.getUnitPrice())).thenReturn(1000.0);
		PriceResDTO actRes = stockService.getTotalPrice(req);
		assertEquals(resp.getStatusCode(), actRes.getStatusCode());
	}
	
	@Test
	public void testGetStockList() {
		List<Stock> list = new ArrayList<>();	
		Stock stock1 = new Stock();
		stock1.setStockId(1);
		stock1.setStockName("Reliance");
		stock1.setUnitPrice(500);
		stock1.setCriselRating(2);
		Stock stock2 = new Stock();
		stock2.setStockId(2);
		stock2.setStockName("ONGC");
		stock2.setUnitPrice(200);
		stock2.setCriselRating(5);
		list.add(stock1); list.add(stock2);
		Mockito.when(stockRepository.findAll()).thenReturn(list);
		StockDto stockDto = new StockDto();
		BeanUtils.copyProperties(stock1, stockDto);
		List<StockDto> stockDtoList = new ArrayList<>();
		stockDtoList.add(stockDto);
		StockResponseDto stockRes = new StockResponseDto();
		stockRes.setData(stockDtoList);
		StockResponseDto object = stockService.getStockList();
		String name = object.getMessage();
		assertEquals(object.getData().size(),list.size());
	}
}
