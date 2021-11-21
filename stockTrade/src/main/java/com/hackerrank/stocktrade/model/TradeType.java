package com.hackerrank.stocktrade.model;

public enum TradeType {
	BUY("BUY"), SELL("SELL");

    private String code;

    private TradeType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
