package com.hackerrank.stocktrade.service;

import java.util.List;

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
		return tradeRepository.findAll();
	}
	
	public void addNewTrade(Trade trade) {
		tradeRepository.save(trade);
	}

}
