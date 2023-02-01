package com.org.rbc.stock.market.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.rbc.stock.market.models.StockData;


public interface StockMarketRepository extends CrudRepository<StockData, Long>{

	//custome method for getting stocks by stock name
	List<StockData> findByStock(String stockName);
}
