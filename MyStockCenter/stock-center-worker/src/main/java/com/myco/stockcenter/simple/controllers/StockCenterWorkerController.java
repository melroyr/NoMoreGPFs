/*
 * Copyright 2014-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.myco.stockcenter.simple.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myco.stockcenter.simple.utils.TickerActionAdvisor;

@RestController
@RequestMapping("/scw/v1")
public class StockCenterWorkerController {

	private static final Logger log = LoggerFactory.getLogger(StockCenterWorkerController.class);
	
	@PostMapping("/api/processTicker")
	public void processTicker(@RequestBody String ticker) {

		System.out.println("Ticker: " + ticker);
		log.info("Log Ticker: " + ticker);
		TickerActionAdvisor tickerActionAdvisor = new TickerActionAdvisor();
		tickerActionAdvisor.launch(ticker);
	}
	
	@PostMapping(value = "/postdata")
    public String PostData(){

       return "{\n" +
               "   \"value\":\"4\",\n" +
               "   \"name\":\"David\"\n" +
               "}";
    }
}
