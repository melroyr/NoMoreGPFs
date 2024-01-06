package com.myco.stockcenter.simple.executor;

import com.myco.stockcenter.simple.utils.GlobalQuote;

public class StockQuoteTask extends Thread {
	
    private String name;
    private GlobalQuote globalQuote;

    public StockQuoteTask(String name, GlobalQuote globalQuote) {
        this.name = name;
        this.globalQuote = globalQuote;
    }

    @Override
    public void run() {
        System.out.println("Runnable Task with " + name + " on thread " + Thread.currentThread().getName());
    }

}
