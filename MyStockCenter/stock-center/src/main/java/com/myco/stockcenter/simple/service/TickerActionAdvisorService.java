package com.myco.stockcenter.simple.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.myco.stockcenter.simple.utils.StockInfo;
import com.myco.stockcenter.simple.utils.StockQuote;

import lombok.Data;

@Data
@Component
public class TickerActionAdvisorService extends Thread {
	
	private String tickerSymbol;
	private static String data;
	private float initialStockPrice;
	private StockQuote stockQuote;
	
	private void getData() throws IOException {
		StockInfo stockInfo = new StockInfo();
		data = stockInfo.getTimeSeriesDaily(tickerSymbol);
		if(!data.isEmpty()) {
			ObjectReader or = new ObjectMapper().reader();
			stockQuote = or.readValue(data, StockQuote.class);
			//System.out.println("Ticker Symbol: " + stockQuote.getGlobalQuote().getSymbol());
		}
	}
	
	private void setInintialPrice() throws IOException {
		//String data = "{    \"globalQuote\": {        \"symbol\": \"MSFT\",        \"open\": \"373.6800\",        \"high\": \"375.1800\",        \"low\": \"372.7100\",        \"price\": \"374.5800\",        \"volume\": \"17107484\",        \"latesttradingday\": \"2023-12-22\",        \"previousclose\": \"373.5400\",        \"change\": \"1.0400\",        \"changepercent\": \"0.2784\"    }}        \"previousclose\": \"373.5400\",        \"change\": \"1.0400\",        \"changepercent\": \"0.2784\"    }}";
		initialStockPrice = stockQuote.getGlobalQuote().getPrice();
	}
	
	private void check() throws IOException {
		Date date = new Date();
		long time = date.getTime();
		System.out.println("Initial Time: " + time);
		
		Calendar calOpen = Calendar.getInstance();
		calOpen.set(Calendar.HOUR_OF_DAY,9);
		calOpen.set(Calendar.MINUTE,30);
		calOpen.set(Calendar.SECOND,0);
		calOpen.set(Calendar.MILLISECOND,0);

		long stockOpen = calOpen.getTime().getTime();
		System.out.println("Stock Open:" + stockOpen);
		
		for(int j=0; j<18; j++) {
			System.out.println("j: " + j);
			if(time > stockOpen) {
				for(int i=0; i<12; i++) {
					System.out.println("i: " + i);
					try {
						
						while (tickerSymbol != null) {
							System.out.println("Ticker Symbol: " + tickerSymbol);
							getData();
							float currentMSFTStockPrice = stockQuote.getGlobalQuote().getPrice();
							if(currentMSFTStockPrice > initialStockPrice) {
								System.out.println("Sell" + i);
							} else if (currentMSFTStockPrice < initialStockPrice) {
								System.out.println("Buy" + i);
							} else {
								System.out.println("Hold " + i);
							}
							try {
								Thread.sleep(30000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} catch (Throwable t) {
						t.printStackTrace();
					}
				}
			} else {
				time = new Date().getTime();
				System.out.println("Updated time: " + time);
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		System.out.println("Done for the day. Good luck again tomorrow");
	}
	
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	
	//@PostConstruct
	@Override
	public void run() {
		
		System.out.println("Ticker Symbol Advisor running: " + tickerSymbol);
		TickerActionAdvisorService json2Java = new TickerActionAdvisorService();
		try {
//			ResourceLoader rl = new ClassRelativeResourceLoader(TickerActionAdvisor.class);
//			Resource resource = rl.getResource("classpath:InterestedTickerSymbols.txt");
//			File file = resource.getFile();
//			BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
//			String tickerSymbol = bufferedReader.readLine();
			
			while(tickerSymbol != null) {
				json2Java.getData();
				if(!data.isEmpty()) {
					json2Java.setInintialPrice();
					json2Java.check();
				}
//				tickerSymbol = bufferedReader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
