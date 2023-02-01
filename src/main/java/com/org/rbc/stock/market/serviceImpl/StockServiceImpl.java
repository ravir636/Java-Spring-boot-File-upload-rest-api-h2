package com.org.rbc.stock.market.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rbc.stock.market.models.StockData;
import com.org.rbc.stock.market.repository.StockMarketRepository;
import com.org.rbc.stock.market.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockMarketRepository stockMarketRepository;

	@Override
	public List<StockData> getListOfStockData(String stockName)throws Exception {
		List<StockData> data = stockMarketRepository.findByStock(stockName);
		return data;
	}

	@Override
	public void saveData(List<StockData> data)throws Exception {
		stockMarketRepository.saveAll(data);
	}

	
}
