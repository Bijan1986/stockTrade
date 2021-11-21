package com.hackerrank.stocktrade.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Bijan Nayak
 *
 */

@Entity(name = "TRADE")
public class Trade {
	@Id
	@Column(name = "TRADE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Trade id can not be null or void")
	private Long id;

	@Column(name = "TRADE_TYPE")
	private String type;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "USER_ID")
	private User userId;

	@Column(name = "TRADE_SYMBOL")
	private String symbol;

	@Column(name = "TRADE_SHARES")
	private Integer shares;

	@Column(name = "TRADE_PRICE")
	private Float price;

	@Column(name = "TRADE_TIMESTAMP") // 2013-09-05 05:12:46.855856
	private Date timestamp;

	public Trade(Long id, String type, User userId, String symbol, Integer shares, Float price, Date timestamp) {
		this.id = id;
		this.type = type;
		this.userId = userId;
		this.symbol = symbol;
		this.shares = shares;
		this.price = price;
		this.timestamp = timestamp;
	}

	public Trade() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
