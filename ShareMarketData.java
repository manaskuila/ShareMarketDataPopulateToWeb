package com.manas.org.ShareMarketData.model;

import java.math.BigDecimal;
import java.util.Date;

public class ShareMarketData {
	
	private String symbol;
	private Date date;
	private Long volume;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal open;
	private BigDecimal close;
	private BigDecimal adjClose;

	public BigDecimal getAdjClose() {
		return adjClose;
	}
	public void setAdjClose(BigDecimal adjClose) {
		this.adjClose = adjClose;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public BigDecimal getClose() {
		return close;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	

}
