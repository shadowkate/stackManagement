package com.stack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.dto.OrderDto;
import com.stack.dto.OrderResDto;
import com.stack.entity.Orders;
import com.stack.entity.Stock;
import com.stack.respository.OrdersRepository;
import com.stack.respository.StockRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrdersRepository orderRepository;
	
	
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public OrderResDto getAll(Integer userId) {
		List<Orders> orderList = orderRepository.findAllByuserId(userId);
		List<OrderDto> orderDtoList = new ArrayList<>();
		OrderResDto orderResDto = new OrderResDto();
		for(Orders list  :orderList) {
			Optional<Stock> stockOP = stockRepository.findById(list.getStockId());
			Stock stock = stockOP.get();
			OrderDto order = new OrderDto();
			order.setOrderedDate(list.getOrderDate());
			order.setQuantity(list.getQuantity());
			order.setStatus(list.getOrderStatus());
			order.setStockName(stock.getStockName());
			order.setTotalPrice(list.getTotalPrice());
			order.setUnitPrice(list.getUnitPrice());
			orderDtoList.add(order);
		}
		orderResDto.setData(orderDtoList);
		orderResDto.setMessage("my orders");
		orderResDto.setStatus("SUCCESS");
		orderResDto.setStatusCode(200);
		return orderResDto;
	}

}
