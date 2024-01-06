package com.myco.stockcenter.simple.executor;

import java.util.Date;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolTaskSchedulerExamples {
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private CronTrigger cronTrigger;

    @Autowired
    private PeriodicTrigger periodicTrigger;

    //@PostConstruct
    public void scheduleRunnableWithCronTrigger() {
        taskScheduler.schedule(new StockQuoteTask("Current Date", null), new Date());
        taskScheduler.scheduleWithFixedDelay(new StockQuoteTask("Fixed 1 second Delay", null), 1000);
        taskScheduler.scheduleWithFixedDelay(new StockQuoteTask("Current Date Fixed 1 second Delay", null), new Date(), 1000);
        taskScheduler.scheduleAtFixedRate(new StockQuoteTask("Fixed Rate of 2 seconds", null), new Date(), 2000);
        taskScheduler.scheduleAtFixedRate(new StockQuoteTask("Fixed Rate of 2 seconds", null), 2000);
        taskScheduler.schedule(new StockQuoteTask("Cron Trigger", null), cronTrigger);
        taskScheduler.schedule(new StockQuoteTask("Periodic Trigger", null), periodicTrigger);
    }

    
}