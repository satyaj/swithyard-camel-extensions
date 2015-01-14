package com.example.switchyard.switchyard_transformation;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.BindyDataFormat;
import org.apache.camel.model.dataformat.XStreamDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;



public class CamelServiceBuilder extends RouteBuilder {
	private static Logger LOG = LoggerFactory.getLogger(CamelServiceBuilder.class);
	   
	public void configure() {

		DataFormat bindy = new BindyCsvDataFormat(ContactDetails.class);

		
		from("switchyard://CamelService")
		.log("Received message for 'CamelService' : ${body}")
		.unmarshal(bindy)
		.log("After Unmarshalling with bindy : ${body}")

	}

}
