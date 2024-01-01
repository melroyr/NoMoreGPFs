package com.myco.stockcenter.simple.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TickerActionAdvisorInvoker {
	
	@PostConstruct
	public void invokeAdvisor() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		ResourceLoader rl = new ClassRelativeResourceLoader(TickerActionAdvisor.class);
		Resource resource = rl.getResource("classpath:InterestedTickerSymbols.txt");
		File file = resource.getFile();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
		String tickerSymbol = bufferedReader.readLine();
		
		while(tickerSymbol != null) {
			
//			// returns the Class object for this class 
//	        Class tickerSymbolAdvisor = Class.forName("com.myco.stockcenter.simple.utils.TickerSymbolAdvisor"); 
//	        
//			Class[] parameterType = new Class[1]; 
//	        parameterType[0] = String.class; 
//	        
//	        Object obj = tickerSymbolAdvisor.getDeclaredConstructor().newInstance();
	        
			System.out.println("Launching Advisor for: " + tickerSymbol);
			TickerActionAdvisor tickerSymbolAdvisor = new TickerActionAdvisor();
			tickerSymbolAdvisor.launch(tickerSymbol);
	        			
			tickerSymbol = bufferedReader.readLine();
		}
	}

}
