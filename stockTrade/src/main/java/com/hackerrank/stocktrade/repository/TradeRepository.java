package com.hackerrank.stocktrade.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.model.Trade;

/**
 * 
 * @author Bijan Nayak
 *
 */

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

	@Query(value = "SELECT * FROM TRADE Where User_id = ?1", nativeQuery = true)
	List<Trade> getAllTradesByUserId(Long id);
	
	@Query(value = "SELECT * FROM TRADE WHERE TRADE_TYPE LIKE ?2 AND TRADE_SYMBOL LIKE ?1 AND TRADE_TIMESTAMP between ?3 AND ?4", nativeQuery = true)
	List<Trade> getAllTradeByStockSymbolAndTradeType(String stockSymbol , String tradeType, Date startDate, Date endDate);

}
