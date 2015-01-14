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

	
	   final String message = "Prefecture : H“cŒ§" +
               "Line : Šâ\u008Fé•Ÿ–“" +
               "City : —R—˜–{‘‘Žs" +
               "PrefectureKana : ±·À¹Ý" +
               "LineKana : ²Ü·Ì¸ÉÏÀ" +
               "CityKana : ÕØÎÝ¼Þ®³¼" ;
		
 
	   
	public void configure() {
		MyLoggingSentEventNotifer notifier = new MyLoggingSentEventNotifer();
		
		try {
			notifier.doStart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getContext().getManagementStrategy().addEventNotifier(notifier);
	
		XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
		xmlJsonFormat.setEncoding("UTF-8");
/*
		xmlJsonFormat.setForceTopLevelObject(true);
		xmlJsonFormat.setTrimSpaces(true);
		xmlJsonFormat.setRootName("newRoot");
		xmlJsonFormat.setSkipNamespaces(true);
		xmlJsonFormat.setRemoveNamespacePrefixes(true);
		xmlJsonFormat.setExpandableProperties(Arrays.asList("d", "e"));
*/
		//xmlJsonDataFormat.set

		
		from("switchyard://CamelService")
		.log("Begin Time: " + System.currentTimeMillis())
		.log("UTF - 8 : ${body}")
		.log("Message is : " + message)
		.marshal(xmlJsonFormat)
		.log("Received message for 'CamelService' : ${body}")
		.log("End Time: " + System.currentTimeMillis())
		.to("direct:a");
		
		from("direct:a")
		.log("At the last endpoint");
		
		
		
	}

}
