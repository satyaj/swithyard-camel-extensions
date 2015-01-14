package com.example.switchyard.switchyard_transformation;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.builder.BuilderSupport;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;
import org.apache.camel.spi.DataFormat;
import org.switchyard.common.camel.SwitchYardCamelContext;



public class CamelServiceBuilder extends RouteBuilder {
	
    
	public void configure() {

		XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
		xmlJsonFormat.setEncoding("UTF-8");

		
		from("switchyard://CamelService")
		.log("Received message for 'CamelService' : ${body}")
		.marshal(xmlJsonFormat)
		.log("After Unmarshalling with xmljson : ${body}")
		
		
		
	}

}
