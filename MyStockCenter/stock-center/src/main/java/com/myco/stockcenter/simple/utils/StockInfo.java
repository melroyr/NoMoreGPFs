package com.myco.stockcenter.simple.utils;


import java.util.Arrays;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class StockInfo {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public String getTimeSeriesDaily(String tickerSymbol){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        String data = restTemplate.exchange(
        		"https://www.alphavantage.co/query?function=GLOBAL_QUOTE&"
        		+ "symbol="+tickerSymbol+"&apikey=J62210IMY0HDA5P9",
        		HttpMethod.GET,entity,String.class).getBody();
        //System.out.println("Data: " + data);
        StringBuffer dataBuffer = new StringBuffer();
        if (!data.contains("Information")){
	        Scanner scanner = new Scanner(data);
	        
	        while (scanner.hasNextLine()) {
	          String line = scanner.nextLine();
	          //System.out.println("line: " + line);
	          if(line.contains("Global")) {
	        	  dataBuffer.append(processLine(line));
	          } else if (line.contains(".")) {
	        	  dataBuffer.append(processPeriod(line));
	          } else {
	        	  dataBuffer.append(line);
	          }
	        }
	        scanner.close();
        } else {
        	System.out.println("Daily Alpha Vantage limit reached");
        }
        
        //System.out.println("Modified Data: " + dataBuffer);
        return dataBuffer.toString();
        
    }
	
	private String processLine(String line){
		String replacedString = line;
		if (line.contains("Global")) {
			replacedString = line.replace("Global ", "global");
		} else if (line.contains("trading")) {
			replacedString = line.replace("latest trading ", "latesttrading");
		} else if (line.contains("previous")){
			replacedString = line.replace("previous ", "previous");
		} else if (line.contains("percent")) {
			replacedString = line.replace(" percent", "percent");
			replacedString = replacedString.replace("%", "");
		}
		return replacedString;
	}
	
	private String processPeriod(String line) {
		int index = line.indexOf("\"");
		String stringToReplace = line.substring(index, index+5);
		String replacedString = line.replace(stringToReplace,"\"");
		return processLine(replacedString);
	}
	
//	public static void main(String[]args) {
//		StockInfo stockInfo = new StockInfo();
//		stockInfo.getTimeSeriesDaily();
//	}
	
	//https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=demo
	//https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=my_api_key
	//J62210IMY0HDA5P9

}
