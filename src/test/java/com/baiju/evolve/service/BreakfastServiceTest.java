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
@SpringBootTest(classes = { MenuFactory.class, BreakfastService.class })
public class BreakfastServiceTest {
	
	@Autowired
	MenuFactory menuFactory;
	
	MenuService breakfastService;
	
	@Before
	public void setUp() {
		breakfastService = MenuFactory.getService("Breakfast");
	}
	
	@Test
	public void testBreakfastProcess() {
		System.out.println("START testBreakfastProcess ");
		String menuValue = "1,2,3";
		String returnValue = breakfastService.process(menuValue);
		
		//assertEquals("Eggs, Toast, Coffee", returnValue, "should be Eggs, Toast, Coffee");
		Assert.assertEquals("should be Eggs, Toast, Coffee", returnValue, "Eggs, Toast, Coffee");
	}

	@Test
	public void testBreakfastProcessRandomOrder() {
		System.out.println("START testProcessReverse ");
		String menuValue = "2,3,1";
		String returnValue = breakfastService.process(menuValue);
		
		//assertEquals("Eggs, Toast, Coffee", returnValue, "should be Eggs, Toast, Coffee");
		Assert.assertEquals("should be Eggs, Toast, Coffee", returnValue, "Eggs, Toast, Coffee");
	}

	@Test
	public void testBreakfastProcessMultiple() {
		System.out.println("START testProcessMultiple ");
		String menuValue = "1,2,3,3,3";
		String returnValue = breakfastService.process(menuValue);
		
		Assert.assertEquals("should be Eggs, Toast, Coffee(3)", returnValue, "Eggs, Toast, Coffee(3)");
	}

	@Test
	public void testBreakfastNegSideProcess() {
		System.out.println("START testBreakfastNegSideProcess ");
		String menuValue = "1";
		String returnValue = breakfastService.process(menuValue);
		
		Assert.assertEquals("should be Unable to process: Side is missing", returnValue, "Unable to process: Side is missing");
	}

	@Test
	public void testBreakfastNegMainProcess() {
		System.out.println("START testBreakfastNegSideProcess ");
		String menuValue = "2";
		String returnValue = breakfastService.process(menuValue);
		
		Assert.assertEquals("should be Unable to process: Main is missing", returnValue, "Unable to process: Main is missing");
	}

}
