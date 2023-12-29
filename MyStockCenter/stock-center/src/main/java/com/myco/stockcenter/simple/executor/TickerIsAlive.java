package com.myco.stockcenter.simple.executor;

import java.util.Date;

import lombok.Data;

@Data
public class TickerIsAlive {
	
	private String symbol;
	private Date lastRecordedDate;

}
