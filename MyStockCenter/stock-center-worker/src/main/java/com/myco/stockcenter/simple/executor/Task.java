package com.myco.stockcenter.simple.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Task implements Runnable {
	
	 private static Logger logger = LoggerFactory.getLogger(Task.class);

	@Override
	public void run() {
		// task details
		System.out.println("In Task run");
		
	}

}
