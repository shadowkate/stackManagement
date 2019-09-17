package com.stack.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stack.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}