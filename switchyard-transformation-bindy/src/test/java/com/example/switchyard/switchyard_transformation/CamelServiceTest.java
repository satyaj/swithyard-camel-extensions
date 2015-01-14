package com.example.switchyard.switchyard_transformation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class CamelServiceTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("CamelService")
	private Invoker service;

	@Test
	public void testPing() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		
		
		String message = testKit.readResourceString("input.txt");
		System.out.println("Message : " + message);
		service.operation("ping").sendInOnly(message);
		System.out.println("After calling the ping operation.");
		// validate the results
		//Assert.assertTrue("Implement me", false);
	}

}
