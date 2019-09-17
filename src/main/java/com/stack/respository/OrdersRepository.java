package com.stack.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stack.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	List<Orders> findAllByuserId(Integer userId);
}
