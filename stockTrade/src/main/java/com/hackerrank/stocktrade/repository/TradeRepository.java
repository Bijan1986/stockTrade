package com.hackerrank.stocktrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

}
