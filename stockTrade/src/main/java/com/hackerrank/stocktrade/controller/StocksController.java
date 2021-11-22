package com.hackerrank.stocktrade.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.service.TradeService;

/**
 * 
 * @author Bijan Nayak
 *
 */
@RestController
@RequestMapping(value = "/stocks")
public class StocksController {
	/**
	 * return the highest and the lowest price of the stock symbol in the given date
	 * range GET /stocks/{stockSymbol}/price?start={startdate}&end={endDate} 404/200
	 * 
	 * the response should have the below Symbol: The symbol of the requested
	 * product Highest: the highest price of the requested stock symbol Lowest: the
	 * lowest price of the requested stock symbol for 404: {"mesage": "there are no
	 * trades in the given data range" }
	 * 
	 */
	@Autowired
	private TradeService tradeService;
	
	@GetMapping("/{stocksymbol}")
	public  ResponseEntity<Object> getThehighestAndLowestStock(@PathVariable("stocksymbol") String stocksymbol,
			@RequestParam("start") String start, @RequestParam("end") String end) {
		Map<String,Float> maxAndMin = tradeService.getTradeBySymbolAndDateRange(stocksymbol,start,end);
		if(maxAndMin.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no traes in the given date range");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("The maximum trade price  :"+maxAndMin.get("max")+"\n minimum trade price is : "+maxAndMin.get("min"));
		}

	}

}
