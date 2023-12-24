package com.myco.stockcenter.simple.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import lombok.Data;

@Data
public class Json2Java {
	
	private static String data;
	private float initialMSFTStockPrice;
	private StockQuote stockQuote;
	
	private void getData() throws IOException {
		StockInfo stockInfo = new StockInfo();
		data = stockInfo.getTimeSeriesDaily();
		if(!data.isEmpty()) {
			ObjectReader or = new ObjectMapper().reader();
			stockQuote = or.readValue(data, StockQuote.class);
			//System.out.println("Ticker Symbol: " + stockQuote.getGlobalQuote().getSymbol());
		}
	}
	
	private void setInintialPrice() throws IOException {
		//String data = "{    \"globalQuote\": {        \"symbol\": \"MSFT\",        \"open\": \"373.6800\",        \"high\": \"375.1800\",        \"low\": \"372.7100\",        \"price\": \"374.5800\",        \"volume\": \"17107484\",        \"latesttradingday\": \"2023-12-22\",        \"previousclose\": \"373.5400\",        \"change\": \"1.0400\",        \"changepercent\": \"0.2784\"    }}        \"previousclose\": \"373.5400\",        \"change\": \"1.0400\",        \"changepercent\": \"0.2784\"    }}";
		initialMSFTStockPrice = stockQuote.getGlobalQuote().getPrice();
	}
	
	private void check() throws IOException {
		for(int i=0; i<10; i++) {
			getData();
			float currentMSFTStockPrice = stockQuote.getGlobalQuote().getPrice();
			if(currentMSFTStockPrice > initialMSFTStockPrice) {
				System.out.println("Sell");
			} else if (currentMSFTStockPrice < initialMSFTStockPrice) {
				System.out.println("Buy");
			} else {
				System.out.println("Hold");
			}
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		Json2Java json2Java = new Json2Java();
		try {
			json2Java.getData();
			if(!data.isEmpty()) {
				json2Java.setInintialPrice();
				json2Java.check();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
