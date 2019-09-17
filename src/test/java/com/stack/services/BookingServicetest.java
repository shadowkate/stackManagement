package com.stack.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.stack.dto.PutOrderDto;
import com.stack.dto.PutOrderResponseDto;
import com.stack.entity.Orders;
import com.stack.respository.OrdersRepository;
import com.stack.service.PutOrderServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookingServicetest {
	
	@InjectMocks
	PutOrderServiceImpl putOrderServiceImpl;
	
	@Mock
	OrdersRepository orderRepository;
	
	public PutOrderDto getPutOrderDto()
	{
		PutOrderDto putOrderDto = new PutOrderDto();
		putOrderDto.setPrice(5000);
		putOrderDto.setQuantity(500);
		putOrderDto.setStatus("SUCCESS");
		putOrderDto.setStockId(1);
		putOrderDto.setUnitPrice(100);
		putOrderDto.setUserId(1);
		return putOrderDto;
	}
	
	public Orders getOrders()
	{
		Orders orders = new Orders();
		orders.setOrderId(1);
		orders.setOrderStatus("SUCCESS");
		orders.setQuantity(500);
		orders.setStockId(1);
		orders.setTotalPrice(5000);
		orders.setUnitPrice(100);
		orders.setUserId(1);
		return orders;
	}
	
	
	public Orders getPositiveOrders()
	{
		Orders orders = new Orders();
		orders.setQuantity(500);
		orders.setStockId(1);
		orders.setTotalPrice(5000);
		orders.setUnitPrice(100);
		orders.setUserId(1);
		return orders;
	}
	
	@Test
	public void putOrderNegative()
	{
		//Mockito.when(orderRepository.save(getOrders())).thenReturn(getOrders());
		PutOrderResponseDto putOrderResponse = putOrderServiceImpl.addOrder(getPutOrderDto());
		Assert.assertEquals("order has not been created", putOrderResponse.getMessage());
	}
	
	@Test
	public void putOrderPositive()
	{
		Orders orders = new Orders();
	//	Mockito.when(orderRepository.save(getOrders())).thenReturn(orders);
		PutOrderResponseDto putOrderResponse = putOrderServiceImpl.addOrder(getPutOrderDto());
		System.out.print("putResponse "+putOrderResponse.getMessage());
		Assert.assertEquals("order has not been created", putOrderResponse.getMessage());
	}

}
