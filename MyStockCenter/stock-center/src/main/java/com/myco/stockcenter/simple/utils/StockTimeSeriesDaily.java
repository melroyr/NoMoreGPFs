package com.myco.stockcenter.simple.utils;

import com.chilkatsoft.CkRest;

public class StockTimeSeriesDaily {

	  public static void main(String argv[]) {
	    // This example requires the Chilkat API to have been previously unlocked.
	    // See Global Unlock Sample for sample code.

	    CkRest rest = new CkRest();

	    // Connect to the REST server.
	    boolean bTls = true;
	    int port = 443;
	    boolean bAutoReconnect = true;
	    boolean success = rest.Connect("www.alphavantage.co",port,bTls,bAutoReconnect);
	    if (success != true) {
	        System.out.println(rest.lastErrorText());
	        return;
	        }

	    // Get a stock quote:
	    // Sending GET request to https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=my_api_key
	    success = rest.AddQueryParam("function","TIME_SERIES_DAILY");
	    success = rest.AddQueryParam("symbol","AAPL");
	    success = rest.AddQueryParam("apikey","my_api_key");
	    String responseJson = rest.fullRequestNoBody("GET","/query");
	    if (rest.get_LastMethodSuccess() != true) {
	        System.out.println(rest.lastErrorText());
	        return;
	        }

	    System.out.println(responseJson);

	    // Sample response:
	    // {
	    //     "Meta Data": {
	    //         "1. Information": "Daily Prices (open, high, low, close) and Volumes",
	    //         "2. Symbol": "AAPL",
	    //         "3. Last Refreshed": "2019-12-06",
	    //         "4. Output Size": "Compact",
	    //         "5. Time Zone": "US/Eastern"
	    //     },
	    //     "Time Series (Daily)": {
	    //         "2019-12-06": {
	    //             "1. open": "267.4800",
	    //             "2. high": "271.0000",
	    //             "3. low": "267.3000",
	    //             "4. close": "270.7100",
	    //             "5. volume": "25447644"
	    //         },
	    //         "2019-12-05": {
	    //             "1. open": "263.7900",
	    //             "2. high": "265.8900",
	    //             "3. low": "262.7300",
	    //             "4. close": "265.5800",
	    //             "5. volume": "18661343"
	    //         },
	    //         "2019-12-04": {
	    //             "1. open": "261.0700",
	    //             "2. high": "263.3100",
	    //             "3. low": "260.6800",
	    //             "4. close": "261.7400",
	    //             "5. volume": "16810388"
	    //         },
	    // ...
	    //         "2019-07-18": {
	    //             "1. open": "204.0000",
	    //             "2. high": "205.8800",
	    //             "3. low": "203.7000",
	    //             "4. close": "205.6600",
	    //             "5. volume": "18582161"
	    //         }
	    //     }
	    // }
	  }
	}
