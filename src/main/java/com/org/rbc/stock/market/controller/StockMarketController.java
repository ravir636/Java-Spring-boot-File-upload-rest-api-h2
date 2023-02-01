package com.org.rbc.stock.market.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.org.rbc.stock.market.models.StockData;
import com.org.rbc.stock.market.service.StockService;

/**
 * Rest Controller Entry point for application
 *
 */
@RestController
public class StockMarketController {

	@Autowired
	private StockService stockService;

	// it will upload the stock data
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadData(@RequestParam(name = "file") MultipartFile file) {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			CsvToBean<StockData> csvToBean = new CsvToBeanBuilder(reader).withType(StockData.class).build();
			List<StockData> stockData = csvToBean.parse();
			stockService.saveData(stockData);
		} catch (Exception e) {
			// written 400 for bad request
			return new ResponseEntity<>("Issue while processing request " + e, HttpStatus.BAD_REQUEST);
		}
		// return 201 for content created
		return new ResponseEntity<>("file Uploaded Successfully", HttpStatus.CREATED);
	}

	@PostMapping(value = "/stock/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addStockData(@RequestBody StockData data) {
		try {
			stockService.saveData(Arrays.asList(data));
		} catch (Exception e) {
			// written 400 for bad request
			return new ResponseEntity<>("Issue while processing request " + e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Data Uploaded Successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/stock/get")
	public ResponseEntity<?> addStockData(@RequestParam String stockName) {
		List<StockData> listofStock = new ArrayList<StockData>();
		try {
			listofStock = stockService.getListOfStockData(stockName);
			if (listofStock.isEmpty()) {
				return new ResponseEntity<String>("NO DATA FOUND for stock " + stockName, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Issue while processing request " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<StockData>>(listofStock, HttpStatus.OK);
	}
}
