package com.stack.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stack.dto.PriceRequestDTO;
import com.stack.dto.PriceResDTO;
import com.stack.dto.StockDto;
import com.stack.dto.StockResponseDto;
import com.stack.entity.Stock;
import com.stack.service.StockService;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, StackController.class })
@WebAppConfiguration
public class StockControllerTest {

	@InjectMocks
	private StackController stockController;
	@Mock
	private StockService stockService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
	}

	@Test
	public void updateBreachStatusTest() throws JsonProcessingException, Exception {
		PriceResDTO responseDTO = new PriceResDTO();
		responseDTO.setMessage("SUCCESS");
		responseDTO.setStatusCode(200);
		responseDTO.setMessage("updated stock price calculated successfully");
		responseDTO.setTotalPrice(220);

		PriceRequestDTO requestDTO = new PriceRequestDTO();
		requestDTO.setQuantity(2);
		requestDTO.setStockId(1);

		ResponseEntity<PriceResDTO> expResult = new ResponseEntity<>(responseDTO, HttpStatus.OK);
		when(stockService.getUpdatedPrice(Mockito.anyObject())).thenReturn(responseDTO);
		mockMvc.perform(post("stock/api/updatedPrice").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(requestDTO))).andReturn();
		ResponseEntity<PriceResDTO> actResult = stockController.getUpdatedPrice(requestDTO);
		assertEquals(expResult, actResult);
	}
	
	@Test
    public void getTotalPriceTest() throws JsonProcessingException, Exception {
        PriceResDTO resp = new PriceResDTO();
        resp.setMessage("Valid OTP");
        resp.setStatus("SUCCESS");
        resp.setStatusCode(HttpStatus.OK.value());
        resp.setTotalPrice(10000);
        PriceRequestDTO req = new PriceRequestDTO();
        req.setQuantity(4);
        req.setStockId(1);
        req.setUnitPrice(100);
        ResponseEntity<PriceResDTO> expResult = new ResponseEntity<>(resp, HttpStatus.OK);
        when(stockService.getTotalPrice(Mockito.anyObject())).thenReturn(resp);
        mockMvc.perform(
                post("/stock/api/totalPrice", req).contentType(MediaType.APPLICATION_JSON).content(asJsonString(req)))
                .andReturn();
        ResponseEntity<PriceResDTO> actResult = stockController.getTotalPrice(req);
        assertEquals(expResult, actResult);
    }
	
	@Test
	public void testStockList() {
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
		list.add(stock1);
		list.add(stock2);
		StockDto stockDto = new StockDto();
		BeanUtils.copyProperties(stock1, stockDto);
		List<StockDto> stockDtoList = new ArrayList<>();
		stockDtoList.add(stockDto);
		StockResponseDto stockRes = new StockResponseDto();
		stockRes.setData(stockDtoList);
		stockRes.setStatusCode(200);
		Mockito.when(stockService.getStockList()).thenReturn(stockRes);
		ResponseEntity<StockResponseDto> object = stockController.stockList();
		assertEquals(object.getBody().getStatusCode(), stockRes.getStatusCode());
	}
	
	

	public static String asJsonString(final Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);

	}

}
