package com.org.rbc.stock.market.service;

import java.util.List;

import com.org.rbc.stock.market.models.StockData;

public interface StockService {
	
	public void saveData(List<StockData> data)throws Exception;
	
	public List<StockData> getListOfStockData(String stockName)throws Exception;

	

}
