package com.myco.stockcenter.simple.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class HeartBeatRecorder {
	
	private static HashMap<String, Date> stockTickers = new HashMap<>();;
	
	public static void updateDate(String ticker, Date updatedDate) {
		stockTickers.put(ticker, updatedDate);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		System.out.println("Ticker Up:" + ticker + " at: " + sdf.format(updatedDate));
	}

}
