package com.example.restfulpolygon.controller;
import com.example.restfulpolygon.entity.TickerDetailsEntity;
import com.example.restfulpolygon.service.TickerDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TickerRestController {

    private final TickerDetailsService tickerDetailsService;

    public TickerRestController(TickerDetailsService tickerDetailsService) {
        this.tickerDetailsService = tickerDetailsService;
    }
    
    // Add this method to your existing controller class
    @GetMapping("/api/ticker-details/{ticker}")
    public TickerDetailsEntity getTickerDetails(@PathVariable String ticker) {
        return tickerDetailsService.getTickerDetails(ticker);
    }
    
    // Add this method to your existing controller class
    @GetMapping("/api/ticker-news/{ticker}")
    public TickerDetailsEntity getTickerNews(@PathVariable String ticker) {
        return tickerDetailsService.getTickerNews(ticker);
    }
    
    //https://api.polygon.io/v2/reference/news?apiKey=ZMO4tZdP9xv0AffugMTCKbpgAszbY9Au
    //https://api.polygon.io/v2/reference/news?limit=10&order=descending&sort=published_utc&apiKey=*


}

