package com.myco.stockcenter.simple.utils;

import java.util.Date;

import lombok.Data;

@Data
public class GlobalQuote {
	
	private String symbol;         
	private float open;
	private float high;
	private float low;
	private float price;
	private long volume;
	private Date latesttradingday;
	private float previousclose;
	private float change;
	private float changepercent;
}
