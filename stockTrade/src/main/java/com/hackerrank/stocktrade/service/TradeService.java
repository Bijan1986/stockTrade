package com.hackerrank.stocktrade.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepository;

/**
 * 
 * @author Bijan Nayak
 * 
 *         we mention all service related details here
 *
 */
@Service
public class TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	public List<Trade> getAllTradeList() {
		List<Trade> trades = tradeRepository.findAll();
		return trades;
	}
	
	public void addNewTrade(Trade trade) {
		tradeRepository.save(trade);
	}
	
	public Optional<Trade> findById(Long tradeId) {
		return tradeRepository.findById(tradeId);
	}
	
	public List<Trade> getTradesByUserId(Long userId){
		return tradeRepository.getAllTradesByUserId(userId);
	}
	
	public List<Trade> getTradesByStockSymbolAndTradeTypeFilterdByDate(String stockSymbol, String tradeType, Date startDate, Date endDate){
		
		return tradeRepository.getAllTradeByStockSymbolAndTradeType(stockSymbol, tradeType, startDate, endDate);
	}

}
