package com.baiju.evolve.service;

import org.junit.Assert;
import org.junit.Before;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MenuFactory.class, LunchService.class })
public class LunchServiceTest {
	
	@Autowired
	MenuFactory menuFactory;
	
	MenuService lunchService;
	
	@Before
	public void setUp() {
		lunchService = MenuFactory.getService("Lunch");
	}
	
	@Test
	public void testLunchProcess() {
		System.out.println("START testLunchProcess ");
		String menuValue = "1,2,3";
		String returnValue = lunchService.process(menuValue);
		
		Assert.assertEquals("should be Sandwich, Chips, Soda", returnValue, "Sandwich, Chips, Soda");
	}

	@Test
	public void testLunchNoDrinkProcess() {
		System.out.println("START testLunchNoDrinkProcess ");
		String menuValue = "1,2";
		String returnValue = lunchService.process(menuValue);
		
		Assert.assertEquals("should be Sandwich, Chips, Water", returnValue, 
									  "Sandwich, Chips, Water");
	}

	@Test
	public void testLunchNegMainMultProcess() {
		System.out.println("START testLunchNegMainMultProcess ");
		String menuValue = "1,1,2, 3";
		String returnValue = lunchService.process(menuValue);
		
		Assert.assertEquals("should be Unable to process: Sandwich cannot be ordered more than once", returnValue, 
									  "Unable to process: Sandwich cannot be ordered more than once");
	}

	@Test
	public void testLunchNoDrinkSoWaterProcess() {
		System.out.println("START testLunchNoDrinkSoWaterProcess ");
		String menuValue = "1,2,2";
		String returnValue = lunchService.process(menuValue);
		
		Assert.assertEquals("should be Sandwich, Chips(2), Water", returnValue, "Sandwich, Chips(2), Water");
	}

	@Test
	public void testLunchNothingProcess() {
		System.out.println("START testLunchNothingProcess ");
		String menuValue = "";
		String returnValue = lunchService.process(menuValue);
		
		Assert.assertEquals("should be Unable to process: Main is missing, Side is missing", returnValue, 
									  "Unable to process: Main is missing, Side is missing");
	}

	@Test
	public void testLunchMultChipsProcess() {
		System.out.println("START testLunchNegMainMultProcess ");
		String menuValue = "1,2,2, 3";
		String returnValue = lunchService.process(menuValue);
		
		Assert.assertEquals("should be Sandwich, Chips(2), Soda", returnValue, 
				"Sandwich, Chips(2), Soda");
	}
	@Test
	public void testLunchGarbageDataProcess() {
		System.out.println("START testLunchGarbageDataProcess ");
		String menuValue = "1,2,3,4";
		String returnValue = lunchService.process(menuValue);
		
		Assert.assertEquals("should be Sandwich, Chips, Soda", returnValue, 
				"Sandwich, Chips, Soda");
	}

}
