package com.manas.org.ShareMarketData.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.manas.org.ShareMarketData.model.ShareMarketData;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@Service
public class ShareDataFetch {
	
	private List<ShareMarketData> shareMarketData=new ArrayList<ShareMarketData>();
	
	public List<ShareMarketData> getAllShares(){
		return shareMarketData;
	}
	Calendar from = Calendar.getInstance();
	Calendar to = Calendar.getInstance();
	Calendar cal = Calendar.getInstance();

	@PostConstruct
	public void getAllShareData() throws IOException {
		 List<ShareMarketData> newShareMarketData=new ArrayList<ShareMarketData>();
			from.add(Calendar.YEAR, -1); // from 1 year ago

		//System.out.println(formatter.format(newDate));
		Stock stock = YahooFinance.get("INTC");  //.get("INTC");
		BigDecimal price = stock.getQuote().getPrice();
	//	BigDecimal change = stock.getQuote().getChangeInPercent();
		//BigDecimal peg = stock.getStats().getPeg();
		//BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
		List<HistoricalQuote> stringList=new ArrayList<HistoricalQuote>();
		stringList.addAll(stock.getHistory(from, to, Interval.DAILY));
		for(HistoricalQuote current : stringList) {
			ShareMarketData sharemarketData=new ShareMarketData();
			sharemarketData.setSymbol(current.getSymbol());
			cal=current.getDate();
			sharemarketData.setDate(cal.getTime());
			sharemarketData.setHigh(current.getHigh());
			sharemarketData.setLow(current.getLow());
			sharemarketData.setClose(current.getClose());
			sharemarketData.setOpen(current.getOpen());
			sharemarketData.setVolume(current.getVolume());
			sharemarketData.setAdjClose(current.getAdjClose());
			newShareMarketData.add(sharemarketData);
		/*	System.out.println("Symbol: "+current.getSymbol()+
					" Volume: "+current.getVolume()+ " Date: "+current.getDate().getInstance().getTime()
			+" High: "+current.getHigh()+" Low: "+current.getLow()+
			" Open: "+current.getOpen()+" Close: "+current.getClose());*/
		}

		shareMarketData=newShareMarketData;
		//stock.print();
			}
}
