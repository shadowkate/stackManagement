package com.stack.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.dto.PutOrderDto;
import com.stack.dto.PutOrderResponseDto;
import com.stack.entity.Orders;
import com.stack.entity.User;
import com.stack.exception.StockManagementException;
import com.stack.respository.OrdersRepository;
import com.stack.respository.UserRepository;
import com.stack.utility.MailWithOTPService;


@Service
public class PutOrderServiceImpl implements PutOrderService {

	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MailWithOTPService mailOtpService;
	
	
	public PutOrderResponseDto addOrder(PutOrderDto putOrderDto) throws StockManagementException {
		
	//	String emailId = null;
		
		Orders orders = new Orders();
		PutOrderResponseDto putRespone = new PutOrderResponseDto();
		LocalDate localDate = LocalDate.now();
		orders.setOrderDate(localDate);
		orders.setOrderStatus(putOrderDto.getStatus());
		orders.setQuantity(putOrderDto.getQuantity());
		orders.setStockId(putOrderDto.getStockId());
		orders.setTotalPrice(putOrderDto.getPrice());
		orders.setUserId(putOrderDto.getUserId());
		orders.setUnitPrice(putOrderDto.getUnitPrice());
		Orders orderData= ordersRepository.save(orders);
		if(orderData != null)
		{
			int userId = putOrderDto.getUserId();
			Optional<User> user = userRepository.findById(userId);
			putRespone.setMessage("order has been created");
			putRespone.setStatus("SUCCESS");
			putRespone.setStatusCode(200);
			putRespone.setOrderId(orderData.getOrderId());
			
			
			String body = "Your Order with order id :"+orderData.getOrderId()+" is successful \n Total Price "+orderData.getTotalPrice();
			String subject = "Trading App";
			
			mailOtpService.sendEmail(user.get().getEmail(), subject, body);
			
			return putRespone;
		}else
		{
			putRespone.setMessage("order has not been created");
			putRespone.setStatus("FAILURE");
			putRespone.setStatusCode(500);
			//putRespone.setOrderId(orderData.getOrderId());
			return putRespone;
		}
	}

}
