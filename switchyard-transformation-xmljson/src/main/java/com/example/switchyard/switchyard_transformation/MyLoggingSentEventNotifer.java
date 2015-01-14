package com.example.switchyard.switchyard_transformation;

import java.util.Date;
import java.util.EventObject;

import org.apache.camel.Exchange;
import org.apache.camel.management.event.ExchangeCompletedEvent;
import org.apache.camel.management.event.ExchangeSentEvent;
import org.apache.camel.support.EventNotifierSupport;

public class MyLoggingSentEventNotifer extends EventNotifierSupport {
	 
    public void notify(EventObject event) throws Exception {
 
    	System.out.println(" Event is of type: " + event.getClass().getCanonicalName());
        if (event instanceof ExchangeSentEvent) {
            ExchangeSentEvent sent = (ExchangeSentEvent) event;
            log.info("Took " + sent.getTimeTaken() + " millis to send to: " + sent.getEndpoint());
        }
        if (event instanceof ExchangeCompletedEvent) {;
        ExchangeCompletedEvent exchangeCompletedEvent = (ExchangeCompletedEvent) event;
        Exchange exchange = exchangeCompletedEvent.getExchange();
        String routeId = exchange.getFromRouteId();
        Date created = ((ExchangeCompletedEvent) event).getExchange().getProperty(Exchange.CREATED_TIMESTAMP, Date.class);
        // calculate elapsed time
        Date now = new Date();
        long elapsed = now.getTime() - created.getTime();
        log.info(">>> Took " + elapsed + " millis for the exchange on the route : " + routeId);
    }
    }
 
    public boolean isEnabled(EventObject event) {
        // we only want the sent events
        return event instanceof ExchangeSentEvent;
    }
 
    protected void doStart() throws Exception {
    	  // filter out unwanted events
    	  setIgnoreCamelContextEvents(true);
    	  setIgnoreServiceEvents(true);
    	  setIgnoreRouteEvents(true);
    	  setIgnoreExchangeCreatedEvent(true);
    	  setIgnoreExchangeCompletedEvent(false);
    	  setIgnoreExchangeFailedEvents(true);
    	  setIgnoreExchangeRedeliveryEvents(true);
    	  setIgnoreExchangeSentEvents(false);    
    	  
    	  System.out.println("test .....");
    	  }
 
    protected void doStop() throws Exception {
        // noop
    }
 
}
