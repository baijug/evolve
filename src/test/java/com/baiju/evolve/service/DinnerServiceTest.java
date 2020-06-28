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
@SpringBootTest(classes = { MenuFactory.class, DinnerService.class })
public class DinnerServiceTest {
	
	@Autowired
	MenuFactory menuFactory;
	
	MenuService dinnerService;
	
	@Before
	public void setUp() {
		dinnerService = MenuFactory.getService("Dinner");
	}
	
	@Test
	public void testDinnerProcess() {
		System.out.println("START testDinnerProcess ");
		String menuValue = "1,2,3,4";
		String returnValue = dinnerService.process(menuValue);
		
		Assert.assertEquals("should be Steak, Potatoes, Wine, Water, Cake", returnValue, 
									  "Steak, Potatoes, Wine, Water, Cake");
	}
	
	@Test
	public void testDinnerNoDesertProcess() {
		System.out.println("START testDinnerNoDesertProcess ");
		String menuValue = "1,2,3";
		String returnValue = dinnerService.process(menuValue);
		
		Assert.assertEquals("should be Unable to process: Desert is missing", returnValue, 
									  "Unable to process: Desert is missing");
	}
}
