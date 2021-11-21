package com.hackerrank.stocktrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;
/**
 * 
 * @author Bijan Nayak
 * TradesController
 * this class takes care of most CRUs related to trade
 *
 */
@RestController
@RequestMapping(value = "/")
public class TradesController {
	
	@Autowired
	private TradeService tradeService;
	
	/**
	 * Add new trades
	 * Post call
	 * /trades
	 * if the trade with same id exists then the error code is 400 
	 * else its 201
	 */
	@PostMapping("/trades")
	public void addNewTradePost(@RequestBody Trade trade) {
		tradeService.addNewTrade(trade);
	}
    
	/**
	 * Return a trade filtered by the ID
	 * GET call
	 * /trades/{id}
	 * if the trade with given id does not exist then the response code should be 404
	 * else 200
	 * 
	 */
	@GetMapping("/trades/{id}")
	public  Trade getTradeById( @PathVariable(value = "id") Long id){
		
		return tradeService.findById(id);
	}
	
	/**
	 * Return all trades
	 * GET /trades
	 * JSON array should be stored in ascending order of Trade id
	 */
	@GetMapping("/trades")
	public List<Trade> getAllTrades(){
		List<Trade> trades = tradeService.getAllTradeList();
		return trades;
	}
	
	/**
	 * Return all trade records filtered by user id
	 * /trades/users/{userid} 404/200
	 */
	
	@GetMapping("/trades/users/{userid}")
	public List<Trade> getAllTradesByUserId(@PathVariable(value = "userid") Long userid){
		List<Trade> trades = tradeService.getTradesByUserId(userid);
		return trades;
	}
	
	
	
	
	/**
	 * Return trade records filtered by stock symbol and the trade Type by the given data range
	 * GET
	 *  /trades/stocks/{stocksymbol}?type={tradetype}&start={startDate}&end={endDate} 
	 *  404/200
	 * 
	 */
	
	/**
	 * return the highest and the lowest price of the stock symbol in the given date range
	 * GET
	 *   /stocks/{stockSymbol}/price?start={startdate}&end={endDate}
	 *   404/200
	 *   
	 *   the response should have the below
	 *   Symbol: The symbol of the requested product
	 *   Highest: the highest price of the requested stock symbol
	 *   Lowest: the lowest price of the requested stock symbol
	 *   for 404:
	 *   {"mesage": "there are no trades in the given data range" }
	 *   
	 */
	
	
}
