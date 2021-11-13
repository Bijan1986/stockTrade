package com.hackerrank.stocktrade.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Bijan Nayak
 *
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TRADE")
public class Trade {
	@Id
	@Column(name = "TRADE_ID")
	@NotNull(message = "Trade id can not be null or void")
	private Long id;
	
	@Column(name="TRADE_TYPE")
	private String type;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column(name="TRADE_SYMBOL")
	private String symbol;
	
	@Column(name="TRADE_SHARES")
	private Integer shares;
	
	@Column(name="TRADE_PRICE")
	private Float price;
	
	@Column(name="TRADE_TIMESTAMP")
	private Timestamp timestamp;

}
