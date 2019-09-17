package com.stack.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stack.entity.CurrentStock;

@Repository
public interface CurrentStockRepositoty extends JpaRepository<CurrentStock, Integer>{

	CurrentStock findByStockId(int stockId);

}
