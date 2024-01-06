package com.myco.stockcenter.simple.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

@Component
public class TickerActionAdvicorInvokerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(TickerActionAdvicorInvokerService.class);
	
	@PostConstruct
	public void processTicker() throws Exception {
//		restTemplate.postForObject(
//				"http://localhost:8888/scw/v1/api/processTicker", "APPL", String.class);
//		restTemplate.postForObject(
//				"http://localhost:8888/scw/v1/api/processTicker", "MSFT", String.class);
		TickerActionAdvisorService taas = null;
		
		ClassRelativeResourceLoader rl = new ClassRelativeResourceLoader(TickerActionAdvicorInvokerService.class);
		Resource resource = rl.getResource("classpath:InterestedTickerSymbols.txt");
		File file = resource.getFile();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
		String tickerSymbol = bufferedReader.readLine();
		
		while (tickerSymbol != null) {
			taas = new TickerActionAdvisorService();
			taas.setTickerSymbol(tickerSymbol);
			CompletableFuture.runAsync(taas);
			log.info("Async Successful");
			
			tickerSymbol = bufferedReader.readLine();
		}
	}

}
